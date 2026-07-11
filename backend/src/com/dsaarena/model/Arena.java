package com.dsaarena.model;

public class Arena{
    private long arenaId;
    private String arenaName;
    private String difficulty;
    private int entryFee;
    private int rewardCoins;
    private int minRating;
    private int readingTime;
    private int codingTime;
    public Arena(long arenaId , String arenaName , String difficulty,int entryFee, int rewardCoins, int minRating, int readingTime, int codingTime)
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
    public long getArenaId(){
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

    public static class Match{
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
        public String getMatchStatus(){
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

    public static class User {
        private long id;
        private static long nextUserId = 100000;
        private String username;
        private String email;
        private String password;
        private int coin;
        private int rating;
        private String rank;
        public User(String username , String email , String password){
            this.id = nextUserId;
            nextUserId++;
            this.username = username;
            this.email = email;
            this.password = password;
            this.coin = 2000;
            this.rating = 0;
            this.rank = "Bronze";
        }
        public String getUsername(){
            return username;
        }
        public String getEmail(){
            return email;
        }
        public long getId(){
            return id;
        }
        public int getCoin(){
            return coin;
        }
        public int getRating(){
            return rating;
        }
        public String getRank(){
            return rank;
        }
        public void addCoins(int coinAdd){
            if(coinAdd > 0){
                this.coin += coinAdd;
            }
        }
        public void deductCoins(int coinDeduct){
            if(coinDeduct > 0 && this.coin - coinDeduct >= 0){
                this.coin -= coinDeduct;
            }
        }
        public void setUsername(String username) {
            if(username != null &&username.trim().length() >= 6){
                this.username = username;
            }
        }
        public void setEmail(String email){
            if(email != null && email.contains("@") && email.contains(".")){
                this.email = email;
            }
        }
        public void increaseRating(int incRating){
            if(incRating > 0) {
                this.rating += incRating;
                updateRank();
            }
        }
        public void decreaseRating(int decRating){
            if(decRating > 0 && this.rating >= decRating){
                this.rating -= decRating;
                updateRank();
            }
            else if(decRating > 0 && decRating > this.rating){
                this.rating = 0;
                updateRank();
            }
        }
        @Override
        public String toString() {
            return "User{Id = " + id +" , username = " + username + " , rating = " + rating + " , rank = " + rank + " , coin = " + coin +'}';
        }
        private void updateRank(){
            if(this.rating < 500){
                this.rank = "Bronze";
            }
            else if(this.rating >= 500 && this.rating< 1000){
                this.rank = "Silver";
            }
            else if(this.rating >= 1000 && this.rating < 1500){
                this.rank = "Gold";
            }
            else if(this.rating >= 1500 &&  this.rating < 2000){
                this.rank = "Platinum";
            }
            else if(this.rating >= 2000 && this.rating < 2500){
                this.rank = "Diamond";
            }
            else {
                this.rank = "Master";
            }
        }
    }
}