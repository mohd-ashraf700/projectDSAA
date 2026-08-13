package com.dsaarena.service;

import com.dsaarena.enums.Difficulty;
import com.dsaarena.model.Arena;
import com.dsaarena.model.Match;
import com.dsaarena.model.Question;
import com.dsaarena.repository.ArenaRepository;
import com.dsaarena.repository.QuestionRepository;

import java.util.List;
import java.util.Random;
public class QuestionService {
    private final ArenaRepository arenaRepository;
    private final QuestionRepository questionRepository;
    private final TimerService timerService;

    public QuestionService(ArenaRepository arenaRepository, QuestionRepository questionRepository, TimerService timerService) {
        this.arenaRepository = arenaRepository;
        this.questionRepository = questionRepository;
        this.timerService = timerService;
    }

    //assign question
    public void assignQuestion(Match match){
        if(match == null){
            return;
        }
        int arenaId = match.getArenaId();
        Arena arena = arenaRepository.getArenaById(arenaId);
        Difficulty difficulty = arena.getDifficulty();
        List<Question> questions = questionRepository.getQuestionsByDifficulty(difficulty);
        if(questions.isEmpty()){
            return;
        }
        Random random = new Random();
        Question selectedQuestion = questions.get(random.nextInt(questions.size()));
        match.setQuestionId(selectedQuestion.getQuestionId());
        timerService.startMatch(match);
    }
}
