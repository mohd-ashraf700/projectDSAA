package main.java.dsaarena.service;

import main.java.dsaarena.enums.MatchStatus;
import main.java.dsaarena.enums.Verdict;
import main.java.dsaarena.model.Arena;
import main.java.dsaarena.model.Match;
import main.java.dsaarena.model.Submission;
import main.java.dsaarena.model.User;
import main.java.dsaarena.repository.ArenaRepository;
import main.java.dsaarena.repository.MatchRepository;
import main.java.dsaarena.repository.SubmissionRepository;
import main.java.dsaarena.repository.UserRepository;

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

        //handle only one player not submission case
        if(player1Best == null){
            handleWinner(player2 , player1 , arena , match);
            return;
        }
        if(player2Best == null){
            handleWinner(player1 , player2 , arena , match);
            return;
        }

        // handle both player submitted code situation
        if(player1Best.getVerdict() == Verdict.ACCEPTED &&
                player2Best.getVerdict() == Verdict.ACCEPTED){
            if(player1Best.getSubmissionTime()
                    .isBefore(player2Best.getSubmissionTime())){
                handleWinner(player1 , player2 , arena , match);
            }
            else if(player2Best.getSubmissionTime()
                    .isBefore(player1Best.getSubmissionTime())){
                handleWinner(player2 , player1 , arena , match);
            }
            else{
                if(match.getPlayer1WrongSubmissions() > match.getPlayer2WrongSubmissions()){
                    handleWinner( player2 , player1 , arena , match);
                }
                else if(match.getPlayer1WrongSubmissions() < match.getPlayer2WrongSubmissions()){
                    handleWinner(player1 , player2 , arena , match);
                }
                else{
                    handleDraw(player1 , player2 , arena , match);
                }
            }
            return;
        }

        // only one player get accepted verdict
        if (player1Best.getVerdict() == Verdict.ACCEPTED) {
            handleWinner(player1, player2, arena, match);
            return;
        }

        if (player2Best.getVerdict() == Verdict.ACCEPTED) {
            handleWinner(player2, player1, arena, match);
            return;
        }

        // handle both player submitted but notAccepted code situation
        if(player1Best.getVerdict() != Verdict.ACCEPTED
                && player2Best.getVerdict() != Verdict.ACCEPTED){
            int player1Wrong = match.getPlayer1WrongSubmissions();
            int player2Wrong = match.getPlayer2WrongSubmissions();
            if(player1Wrong > player2Wrong){
                handleWinner(player2 , player1 , arena , match);
                return;
            }
            if(player1Wrong < player2Wrong){
                handleWinner(player1 , player2 , arena , match);
                return;
            }
            if(player1Best.getPassedTestCases() > player2Best.getPassedTestCases()){
                handleWinner(player1 , player2 , arena , match);
                return;
            }
            if(player1Best.getPassedTestCases() < player2Best.getPassedTestCases()){
                handleWinner(player2 , player1 , arena , match);
                return;
            }

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
    private void handleDraw(User player1 , User player2 , Arena arena , Match match){
        int totalRefund = 2 * arena.getEntryFee() - arena.getPlatformFee();
        int refundEachPlayer = totalRefund / 2;
        player1.addCoins(refundEachPlayer);
        player2.addCoins(refundEachPlayer);
        match.completeMatch();
    }

    //winner reward
    private void addWinnerReward(User player , Arena arena){
        int rewardCoins = (2 * arena.getEntryFee()) - arena.getPlatformFee();
        player.addCoins(rewardCoins);
    }
    //increment of rating
    private void increaseWinnerRating(User player , Arena arena){
        int updatedRating = arena.getWinRating();
        player.increaseRating(updatedRating);
    }
    //decrement of rating
    private void decreaseLoserRating(User player , Arena arena){
        int updatedRating = arena.getLossRating();
        player.decreaseRating(updatedRating);
    }

    //Handle winner
    private void handleWinner(User winner,
                              User loser,
                              Arena arena,
                              Match match) {

        addWinnerReward(winner, arena);
        increaseWinnerRating(winner, arena);
        decreaseLoserRating(loser, arena);
        match.completeMatch();
    }
}