package main.java.dsaarena.service;

import main.java.dsaarena.enums.MatchStatus;
import main.java.dsaarena.model.Arena;
import main.java.dsaarena.model.Match;
import main.java.dsaarena.repository.ArenaRepository;
import main.java.dsaarena.repository.MatchRepository;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerService {
    private final ScheduledExecutorService scheduler;
    private final ResultService resultService;
    private final MatchRepository matchRepository;
    private final ArenaRepository arenaRepository;

    public TimerService(ScheduledExecutorService scheduler, ResultService resultService, MatchRepository matchRepository, ArenaRepository arenaRepository) {
        this.scheduler = scheduler;
        this.resultService = resultService;
        this.matchRepository = matchRepository;
        this.arenaRepository = arenaRepository;
    }
    //start Match
    public void startMatch(Match match) {
        match.setStartTime(LocalDateTime.now());
        match.setMatchStatus(MatchStatus.READING);
        startReadingPhase(match);
    }

    private void startReadingPhase(Match match) {
        Arena arena = arenaRepository.getArenaById((match.getArenaId()));
        scheduler.schedule(() -> {
            startCodingPhase(match);
        },arena.getReadingTime(), TimeUnit.MINUTES);
    }

    private void startCodingPhase(Match match) {
        match.setMatchStatus(MatchStatus.LIVE);
        Arena arena = arenaRepository.getArenaById(match.getArenaId());
        scheduler.schedule(() -> {
            finishMatch(match);
        } , arena.getCodingTime() , TimeUnit.MINUTES);
    }

    private void finishMatch(Match match) {
        match.setEndTime(LocalDateTime.now());
        resultService.processResult(match.getMatchId());
    }
}
