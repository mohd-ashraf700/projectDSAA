package main.java.dsaarena.service;
import main.java.dsaarena.enums.MatchStatus;
import main.java.dsaarena.enums.Verdict;
import main.java.dsaarena.model.Match;
import main.java.dsaarena.model.Submission;
import main.java.dsaarena.repository.MatchRepository;
import main.java.dsaarena.repository.SubmissionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SubmissionService {
    private SubmissionRepository submissionRepository;
    private MatchRepository matchRepository;
    public SubmissionService(SubmissionRepository submissionRepository , MatchRepository matchRepository){
        this.submissionRepository = submissionRepository;
        this.matchRepository = matchRepository;
    }

    //submit soln method
    public Submission submitSolution(long matchId,
                                     long playerId,
                                     String language,
                                     String code,
                                     Verdict verdict){
        Match match = matchRepository.getMatchById(matchId);
        if(match == null){
            return null;
        }
        if(match.getPlayer1Id() != playerId && match.getPlayer2Id() != playerId ){
            return null;
        }
        if(match.getMatchStatus() != MatchStatus.LIVE){
            return null;
        }
        if(code == null || code.isBlank()){
            return null;
        }
        if(verdict != Verdict.ACCEPTED){
                match.incrementWrongSubmissionCount(playerId);
        }
        long questionId = match.getQuestionId();
        LocalDateTime submissionTime = LocalDateTime.now();
        Submission submission = new Submission(matchId ,
                                                questionId,
                playerId,
                language,
                code,
                verdict,
                0, //baad m set kr dunga
                0,//yh bhi
                submissionTime);
        submissionRepository.addSubmission(submission);
        return submission;
    }

    //get match submission
    public List<Submission> getMatchSubmissions(long matchId){
        Match match = matchRepository.getMatchById(matchId);
        if(match == null){
            return new ArrayList<>();
        }
        return submissionRepository.getSubmissionsByMatchId(matchId);
    }

}
