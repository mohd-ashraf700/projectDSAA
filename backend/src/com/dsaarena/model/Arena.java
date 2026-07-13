package com.dsaarena.model;

public class Arena{
    private int arenaId;
    private String arenaName;
    private String difficulty;
    private int entryFee;
    private int rewardCoins;
    private int minRating;
    private int readingTime;
    private int codingTime;
    public Arena(int arenaId , String arenaName , String difficulty,int entryFee, int rewardCoins, int minRating, int readingTime, int codingTime)
    {
        this.arenaId = arenaId;
        this.arenaName = arenaName;
        this.difficulty = difficulty;
        this.entryFee = entryFee;
        this.rewardCoins = rewardCoins;
        this.minRating = minRating;
        this.readingTime = readingTime;
        this.codingTime = codingTime;
    }
    public int getArenaId(){
        return arenaId;
    }
    public String getArenaName(){
        return arenaName;
    }
    public String getDifficulty(){
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
}