package main.java.dsaarena.service;

import main.java.dsaarena.enums.Difficulty;
import main.java.dsaarena.model.Arena;
import main.java.dsaarena.model.Match;
import main.java.dsaarena.model.Question;
import main.java.dsaarena.repository.ArenaRepository;
import main.java.dsaarena.repository.QuestionRepository;

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
