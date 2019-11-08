package com.company;

public class Player {
    private String name;
    private int score;

    //Default constructor
    public Player(){
        name = "John Doe";
        score = 0;
    }

    //Fill constructor
    public Player(String n, int s){
        name = n;
        score = s;
    }

    //Functions to make adding and removing points easier
    public void addPoints(int points){
        score += points;
    }

    public void removePoints(int points){
        score -= points;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
