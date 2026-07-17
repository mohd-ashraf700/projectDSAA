package com.dsaarena.model;

import com.dsaarena.enums.Verdict;

import java.time.LocalDateTime;

public class Submission {
    private long submissionId;
    private long questionId;
    private static long nextSubmissionId = 100;
    private long matchId;
    private long playerId;
    private String language;
    private String code;
    private Verdict verdict;
    private int passedTestCases;
    private int totalTestCases;
    private LocalDateTime submissionTime;
    public Submission(long matchId,
                      long questionId,
                      long playerId,
                      String language,
                      String code,
                      Verdict verdict,
                      int passedTestCases,
                      int totalTestCases,
                      LocalDateTime submissionTime
                      ){
        this.submissionId = nextSubmissionId;
        nextSubmissionId++;
        this.matchId = matchId;
        this.playerId = playerId;
        this.questionId = questionId;
        this.language = language;
        this.code = code;
        this.verdict = verdict;
        this.passedTestCases = passedTestCases;
        this.totalTestCases = totalTestCases;
        this.submissionTime = submissionTime;
    }

    public long getQuestionId() {
        return questionId;
    }

    public long getSubmissionId() {
        return submissionId;
    }

    public long getMatchId() {
        return matchId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getLanguage() {
        return language;
    }

    public String getCode() {
        return code;
    }

    public int getPassedTestCases() {
        return passedTestCases;
    }

    public int getTotalTestCases() {
        return totalTestCases;
    }

    public Verdict getVerdict() {
        return verdict;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public boolean isAccepted(){
        return passedTestCases == totalTestCases;
    }
}
