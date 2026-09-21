package main.java.dsaarena.service;

import main.java.dsaarena.model.Arena;
import main.java.dsaarena.model.Match;
import main.java.dsaarena.model.QueueEntry;
import main.java.dsaarena.model.User;
import main.java.dsaarena.repository.ArenaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchmakingService {
    private Map<Integer , List<QueueEntry>> arenaQueues;
    private ArenaRepository arenaRepository;

    public MatchmakingService(){
        arenaQueues = new HashMap<>();
        arenaRepository = new ArenaRepository();
        for(Arena arena : arenaRepository.getAllArenas()){
            arenaQueues.put(arena.getArenaId() , new ArrayList<>());
        }
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
        QueueEntry opponent = tryImmediateMatch(user , arena);

        if(opponent != null){
            if (!reValidationBeforeMatch(user, opponent.getUser(), arena)) {
                return;
            }
            removeUsersFromQueue(user , opponent.getUser(), arena);
            deductEntryFee(user , opponent.getUser(), arena);
            Match match = createMatch(user , opponent.getUser() , arena);
            //start game
        }
    }

    //immediate Match
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

    //reValidation
    private boolean reValidationBeforeMatch(User user , User opponent , Arena arena){
        if(user == null || opponent == null || arena == null){
            return false;
        }
        if(user.getCoin() < arena.getEntryFee() || opponent.getCoin() < arena.getEntryFee()){
            return false;
        }
        if(!isAlreadyInQueue(user , arena) || !isAlreadyInQueue(opponent , arena)){
            return false;
        }
        //isAlreadyInMatch check after matchmaking repository
        return true;
    }

    //userRemoveFromQueue
    private void removeUsersFromQueue(User user, User opponent, Arena arena){
        List<QueueEntry> queue = arenaQueues.get(arena.getArenaId());
        QueueEntry userEntry = null;
        QueueEntry opponentEntry = null;
        for(QueueEntry entry : queue){
            if(entry.getUser().getId() == user.getId()){
                userEntry = entry;
            }
            if(entry.getUser().getId() == opponent.getId()){
                opponentEntry = entry;
            }
        }
        if(userEntry != null){
            queue.remove(userEntry);
        }
        if(opponentEntry != null){
            queue.remove(opponentEntry);
        }
    }

    // coin deduction
    private void deductEntryFee(User user , User opponent , Arena arena){
        user.deductCoins(arena.getEntryFee());
        opponent.deductCoins(arena.getEntryFee());
    }

    //createMatch
    private Match createMatch(User user , User opponent , Arena arena){
        Match match = new Match(user.getId(), opponent.getId(), arena.getArenaId() , arena.getEntryFee(), user.getRating(), opponent.getRating());
        return match;
    }

    //cancel Matchmaking
    public boolean cancelMatchmaking(User user , Arena arena){
        if(user == null || arena == null){
            return false;
        }
        if(!isAlreadyInQueue(user , arena)){
            return false;
        }
        QueueEntry removeEntry = null;
        List<QueueEntry> queue = arenaQueues.get(arena.getArenaId());
        for(QueueEntry entry : queue){
            if(entry.getUser().getId() == user.getId()){
                removeEntry = entry;
                break;
            }
        }
        if(removeEntry != null){
            queue.remove(removeEntry);
            return true;
        }
        return false;
    }
}