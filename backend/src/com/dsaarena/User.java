package com.dsaarena;

public class User {
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
