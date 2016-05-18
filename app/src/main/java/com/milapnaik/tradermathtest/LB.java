package com.milapnaik.tradermathtest;

/**
 * Created by MilapNaik on 5/10/16.
 */

// Class for showing each record of the leaderboard
public class LB {

    private String rank, time;
    private int score;

    public LB(String rank, int score, String time){
        this.setRank(rank);
        this.setScore(score);
        this.setTime(time);
    }

    public String getRank(){
        return rank;

    }

    public void setRank(String rank){
        this.rank = rank;

    }

    public int getScore(){
        return score;

    }

    public void setScore(int score){
        this.score = score;

    }

    public String getTime(){
        return time;

    }

    public void setTime(String time){
        this.time = time;

    }
}
