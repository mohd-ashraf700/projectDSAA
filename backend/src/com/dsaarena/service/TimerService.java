package com.dsaarena.service;

import com.dsaarena.model.Match;
import com.dsaarena.repository.ArenaRepository;
import com.dsaarena.repository.MatchRepository;

import java.util.concurrent.ScheduledExecutorService;

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
}
