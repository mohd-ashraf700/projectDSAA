package com.dsaarena.service;

import com.dsaarena.model.Arena;
import com.dsaarena.model.QueueEntry;
import com.dsaarena.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchmakingService {
    private Map<Integer , List<QueueEntry>> arenaQueues;

    public MatchmakingService(){
        arenaQueues = new HashMap<>();
        arenaQueues.put(1 , new ArrayList<>());
        arenaQueues.put(2 , new ArrayList<>());
        arenaQueues.put(3 , new ArrayList<>());
        arenaQueues.put(4 , new ArrayList<>());
        arenaQueues.put(5 , new ArrayList<>());
        arenaQueues.put(6 , new ArrayList<>());
    }

    // Eligibility validation
    public boolean isEligibleForMatchmaking(User user , Arena arena){
        if(user == null){
            return false;
        }
        if(isAlreadyInQueue(user , arena)){
            return false;
        }
        // already in match

        if(user.getRating() < arena.getMinRating()){
            return false;
        }
        if(user.getCoin() < arena.getEntryFee()){
            return false;
        }
        return true;
    }
    // check if user is already in queue
    private boolean isAlreadyInQueue(User user , Arena arena){
        List<QueueEntry> queue = arenaQueues.get(arena.getArenaId());
        if(queue == null){
            return false;
        }
        for(QueueEntry entry : queue){
           if(entry.getUser().getId() == user.getId()){
                return true;
           }
        }
        return false;
    }

    //start matchmaking
    public void startMatchmaking(User user , Arena arena){
        if(!isEligibleForMatchmaking(user , arena)){
            return;
        }
        QueueEntry entry = new QueueEntry(user , LocalDateTime.now());
        List<QueueEntry> queue = arenaQueues.get(arena.getArenaId());
        queue.add(entry);

    }

    //immediate matchMatch
    private QueueEntry tryImmediateMatch(User user , Arena arena){
        List <QueueEntry> queue = arenaQueues.get(arena.getArenaId());
        for(QueueEntry entry : queue){
            if(entry.getUser().getId() == user.getId()){
                continue;
            }
            if(Math.abs(entry.getUser().getRating() - user.getRating()) == 0){
                return entry;
            }
        }
        return null;
    }
    // find best opponent
    private QueueEntry findBestOpponent(User user , Arena arena){
        List<QueueEntry> queue = arenaQueues.get(arena.getArenaId());
        int minDifference = Integer.MAX_VALUE;
        QueueEntry bestOpponent = null;

        for(QueueEntry entry : queue){
            if(entry.getUser().getId() == user.getId()){
                continue;
            }
            int ratingDifference = Math.abs(user.getRating() - entry.getUser().getRating());
            if(ratingDifference == 0){
                return entry;
            }
            if(ratingDifference < minDifference){
                minDifference = ratingDifference;
                bestOpponent = entry;
            }
        }
        return bestOpponent;
    }
}
