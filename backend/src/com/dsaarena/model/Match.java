package com.dsaarena.model;

import com.dsaarena.enums.MatchStatus;

public class Match{
    private long matchId;
    private static long nextMatchId = 50000;
    private long player1Id;
    private long player2Id;
    private long questionId;
    private long arenaId;
    private long winnerId;
    private int entryFee;
    private int player1RatingAtStart;
    private int player2RatingAtStart;
    private MatchStatus matchStatus;
    private long startTime;
    private long endTime;
    private int player1WrongSubmissions;
    private int player2WrongSubmissions;

    public Match(long player1Id , long player2Id , long arenaId , int entryFee , int player1RatingAtStart , int player2RatingAtStart){
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.arenaId = arenaId;
        this.entryFee = entryFee;
        this.player1RatingAtStart = player1RatingAtStart;
        this.player2RatingAtStart = player2RatingAtStart;
        this.matchId = nextMatchId;
        nextMatchId++;
        this.matchStatus = MatchStatus.Waiting;
        this.questionId = -1;
        this.startTime = 0;
        this.endTime = 0;
        this.winnerId = -1;
        this.player1WrongSubmissions = 0;
        this.player2WrongSubmissions = 0;
    }
    public long getMatchId(){
        return matchId;
    }
    public long getPlayer1Id(){
        return player1Id;
    }
    public long getPlayer2Id(){
        return player2Id;
    }
    public long getQuestionId(){
        return questionId;
    }
    public long getArenaId(){
        return arenaId;
    }
    public MatchStatus getMatchStatus(){
        return matchStatus;
    }
    public int getPlayer1WrongSubmissions(){
        return player1WrongSubmissions;
    }
    public int getPlayer2WrongSubmissions(){
        return player2WrongSubmissions;
    }
    public void incrementWrongSubmissionCount(long playerId){
        if(playerId == player1Id){
            player1WrongSubmissions++;
        }else if(playerId == player2Id){
            player2WrongSubmissions++;
        }
    }
}
