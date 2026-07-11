package com.dsaarena.model;

public class Submission {
    private long submissionId;
    private long questionId;
    private static long nextSubmissionId = 100;
    private long matchId;
    private long playerId;
    private String language;
    private String code;
    private String verdict;
    private int passedTestCases;
    private int totalTestCases;
    private long submissionTime;
    public Submission(long matchId,
                      long questionId,
                      long playerId,
                      String language,
                      String code,
                      String verdict,
                      int passedTestCases,
                      int totalTestCases,
                      long submissionTime
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

    public String getVerdict() {
        return verdict;
    }

    public long getSubmissionTime() {
        return submissionTime;
    }

    public boolean isAccepted(){
        return passedTestCases == totalTestCases;
    }
}
