package com.dsaarena.service;

import com.dsaarena.enums.MatchStatus;
import com.dsaarena.model.Arena;
import com.dsaarena.model.Match;
import com.dsaarena.model.User;
import com.dsaarena.repository.ArenaRepository;
import com.dsaarena.repository.MatchRepository;
import com.dsaarena.repository.SubmissionRepository;
import com.dsaarena.repository.UserRepository;

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
        long player1Id = match.getPlayer1Id();
        long player2Id = match.getPlayer2Id();

        User player1 = userRepository.getUserById(player1Id);
        User player2 = userRepository.getUserById(player2Id);
        if(player1 == null || player2 == null){
            return;
        }

    }
}
