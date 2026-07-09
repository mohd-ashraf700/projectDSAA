package com.dsaarena;

public class Arena{
    private long arenaId;
    private String arenaName;
    private String difficulty;
    private int entryFee;
    private int minRating;
    private int readingTime;
    private int codingTime;
    public Arena(long arenaId , String arenaName , String difficulty,int entryFee, int minRating, int readingTime, int codingTime)
    {
        this.arenaId = arenaId;
        this.arenaName = arenaName;
        this.difficulty = difficulty;
        this.entryFee = entryFee;
        this.minRating = minRating;
        this.readingTime = readingTime;
        this.codingTime = codingTime;
    }
}