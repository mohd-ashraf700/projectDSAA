package com.dsaarena.service;
import com.dsaarena.enums.MatchStatus;
import com.dsaarena.enums.Verdict;
import com.dsaarena.model.Match;
import com.dsaarena.model.Submission;
import com.dsaarena.repository.MatchRepository;
import com.dsaarena.repository.SubmissionRepository;

import static com.dsaarena.enums.MatchStatus.LIVE;

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
    }

}
