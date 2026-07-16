package com.dsaarena.model;

import com.dsaarena.enums.Difficulty;

public class Arena{
    private int arenaId;
    private String arenaName;
    private Difficulty difficulty;
    private int entryFee;
    private int rewardCoins;
    private int minRating;
    private int readingTime;
    private int codingTime;
    private int winRating;
    private int lossRating;

    public Arena(int arenaId , String arenaName , Difficulty difficulty,int entryFee, int rewardCoins, int minRating, int readingTime, int codingTime , int winRating , int lossRating)
    {
        this.arenaId = arenaId;
        this.arenaName = arenaName;
        this.difficulty = difficulty;
        this.entryFee = entryFee;
        this.rewardCoins = rewardCoins;
        this.minRating = minRating;
        this.readingTime = readingTime;
        this.codingTime = codingTime;
        this.winRating = winRating;
        this.lossRating = lossRating;
    }
    public int getArenaId(){
        return arenaId;
    }
    public String getArenaName(){
        return arenaName;
    }
    public Difficulty getDifficulty(){
        return difficulty;
    }
    public int getEntryFee(){
        return entryFee;
    }
    public int getRewardCoins(){
        return rewardCoins;
    }

    public int getMinRating() {
        return minRating;
    }
    public int getReadingTime(){
        return readingTime;
    }
    public int getCodingTime(){
        return codingTime;
    }

    public int getWinRating() {
        return winRating;
    }

    public int getLossRating() {
        return lossRating;
    }
}