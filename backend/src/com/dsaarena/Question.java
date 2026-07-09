package com.dsaarena;

public class Question {
    private long questionId;
    private String title;
    private String difficulty;
    private String topic;
    private int timeLimit;
    private int memoryLimit;
    private int visibleTestCases;
    private int hiddenTestCases;
    public Question(long questionId,
                    String title,
                    String difficulty,
                    String topic,
                    int timeLimit,
                    int memoryLimit,
                    int visibleTestCases,
                    int hiddenTestCases){
        this.questionId = questionId;
        this.title = title;
        this.difficulty = difficulty;
        this.topic = topic;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.visibleTestCases = visibleTestCases;
        this.hiddenTestCases = hiddenTestCases;
    }
}
