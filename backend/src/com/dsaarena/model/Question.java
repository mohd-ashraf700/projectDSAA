package com.dsaarena.model;

import com.dsaarena.enums.Difficulty;

public class Question {
    private long questionId;
    private String title;
    private String problemStatement;
    private String constraints;
    private Difficulty difficulty;
    private String topic;
    private int timeLimit;
    private int memoryLimit;
    private int visibleTestCases;
    private int hiddenTestCases;
    private String sampleInput;
    private String sampleOutput;
    private String explanation;
    public Question(long questionId,
                    String title,
                    String problemStatement,
                    String constraints,
                    Difficulty difficulty,
                    String topic,
                    int timeLimit,
                    int memoryLimit,
                    int visibleTestCases,
                    int hiddenTestCases,
                    String sampleInput,
                    String sampleOutput,
                    String explanation){
        this.questionId = questionId;
        this.title = title;
        this.problemStatement = problemStatement;
        this.constraints = constraints;
        this.difficulty = difficulty;
        this.topic = topic;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.visibleTestCases = visibleTestCases;
        this.hiddenTestCases = hiddenTestCases;
        this.sampleInput = sampleInput;
        this.sampleOutput = sampleOutput;
        this.explanation = explanation;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public String getConstraints() {
        return constraints;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public int getHiddenTestCases() {
        return hiddenTestCases;
    }

    public int getVisibleTestCases() {
        return visibleTestCases;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

}
