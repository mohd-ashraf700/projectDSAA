package com.dsaarena.service;

import com.dsaarena.enums.MatchStatus;
import com.dsaarena.enums.Verdict;
import com.dsaarena.model.Arena;
import com.dsaarena.model.Match;
import com.dsaarena.model.Submission;
import com.dsaarena.model.User;
import com.dsaarena.repository.ArenaRepository;
import com.dsaarena.repository.MatchRepository;
import com.dsaarena.repository.SubmissionRepository;
import com.dsaarena.repository.UserRepository;

import java.util.List;

public class ResultService {
    private MatchRepository matchRepository;
    private UserRepository userRepository;
    private ArenaRepository arenaRepository;
    private SubmissionRepository submissionRepository;

    public ResultService(MatchRepository matchRepository,
                         UserRepository userRepository,
                         ArenaRepository arenaRepository,
                         SubmissionRepository submissionRepository){
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        this.arenaRepository = arenaRepository;
        this.submissionRepository = submissionRepository;
    }

    // process match result
    public void processResult(long matchId){
        Match match = matchRepository.getMatchById(matchId);
        if(match == null){
            return;
        }
        if(match.getMatchStatus() == MatchStatus.COMPLETED || match.getMatchStatus() == MatchStatus.CANCELLED){
            return;
        }
        int arenaId = match.getArenaId();
        Arena arena = arenaRepository.getArenaById(arenaId);
        if (arena == null) {
            return;
        }
        long player1Id = match.getPlayer1Id();
        long player2Id = match.getPlayer2Id();

        User player1 = userRepository.getUserById(player1Id);
        User player2 = userRepository.getUserById(player2Id);
        if(player1 == null || player2 == null){
            return;
        }
        List<Submission> submissions =
                submissionRepository.getSubmissionsByMatchId(matchId);
        Submission player1Best = getBestSubmission(submissions , player1Id);

        Submission player2Best = getBestSubmission(submissions , player2Id);

        //handle condition of draw
        if(player1Best == null && player2Best == null){
            handleDraw(player1 , player2 , arena , match);
            return;
        }
    }
    //get best submission
    private Submission getBestSubmission(List<Submission> submissions,
                                         long playerId){
        Submission bestSubmission = null;
        for(Submission submission : submissions){
            if(submission.getPlayerId() != playerId){
                continue;
            }
            if(submission.getVerdict() == Verdict.ACCEPTED){
                return submission;
            }
            if(bestSubmission == null ||
                        submission.getPassedTestCases() > bestSubmission.getPassedTestCases()){
                    bestSubmission = submission;
            }
        }
        return bestSubmission;
    }
    // handle draw
    void handleDraw(User player1 , User player2 , Arena arena , Match match){
        int totalRefund = 2 * arena.getEntryFee() - arena.getPlatformFee();
        int refundEachPlayer = totalRefund / 2;
        player1.addCoins(refundEachPlayer);
        player2.addCoins(refundEachPlayer);
        match.completeMatch();
    }


}
