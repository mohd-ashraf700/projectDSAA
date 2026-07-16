package com.dsaarena.repository;

import com.dsaarena.enums.Difficulty;
import com.dsaarena.model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionRepository {
    private Map<Long , Question> questions;
    private Map<Difficulty , List<Question>> difficultyQuestions;

    public QuestionRepository(){
        questions = new HashMap<>();
        difficultyQuestions = new HashMap<>();

        initializeDifficultyMap();
        initializeQuestions();
    }

    //initialize question
    private void initializeQuestions(){
        //v1 k last m dekhenge
    }

    //initialize difficultyMap
    private void initializeDifficultyMap(){
        for(Difficulty difficulty : Difficulty.values()){
            difficultyQuestions.put(difficulty , new ArrayList<>());
        }
    }

    // add question method
    private void addQuestion(Question question){
        questions.put(question.getQuestionId() , question);
        difficultyQuestions.get(question.getDifficulty()).add(question);
    }

    //get question by id
    public Question getQuestionById(long questionId){
        return questions.get(questionId);
    }

    //get all question
    public List<Question> getAllQuestions(){
        return new ArrayList<>(questions.values());
    }

    //get questions by difficulty
    public List<Question> getQuestionsByDifficulty(Difficulty difficulty){
        return difficultyQuestions.get(difficulty);
    }
}
