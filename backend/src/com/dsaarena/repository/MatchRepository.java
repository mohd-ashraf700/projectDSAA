package com.dsaarena.repository;

import com.dsaarena.model.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchRepository {
    private Map<Long , Match> matches;

    public MatchRepository(){
        matches = new HashMap<>();
    }

    // add match
    public void addMatch(Match match){
        if(match == null){
            return;
        }
        matches.put(match.getMatchId(), match);
    }

    //get match by id
    public Match getMatchById(long matchId){
        return matches.get(matchId);
    }

    // get all matches
    public List<Match> getAllMatches(){
        return new ArrayList<>(matches.values());
    }

    //remove match by id
    public void removeMatch(long matchId){
        matches.remove(matchId);
    }
}
