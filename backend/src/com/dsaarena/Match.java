package com.dsaarena;

public class Match{
    private long matchId;
    private static long nextMatchId = 100000;
    private long player1Id;
    private long player2Id;
    private long questionId;
    private long arenaId;
    private long winnerId;
    private int entryFee;
    private int player1RatingAtStart;
    private int player2RatingAtStart;
    private String matchStatus;
    private long startTime;
    private long endTime;
    private int player1WrongSubmissions;
    private int player2WrongSubmissions;

    public Match(long player1Id , long player2Id , long questionId , long arenaId , int entryFee , int player1RatingAtStart , int player2RatingAtStart){
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.questionId = questionId;
        this.arenaId = arenaId;
        this.entryFee = entryFee;
        this.player1RatingAtStart = player1RatingAtStart;
        this.player2RatingAtStart = player2RatingAtStart;
        this.matchId = nextMatchId;
        nextMatchId++;
        this.matchStatus = "CREATED";
        this.startTime = 0;
        this.endTime = 0;
        this.winnerId = -1;
        this.player1WrongSubmissions = 0;
        this.player2WrongSubmissions = 0;
    }
}
