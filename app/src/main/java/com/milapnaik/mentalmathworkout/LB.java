package com.milapnaik.mentalmathworkout;

/**
 * Created by MilapNaik on 5/10/16.
 */
public class LB {

    private String rank, score, time;

    public LB(String rank, String score, String time){
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

    public String getScore(){
        return score;

    }

    public void setScore(String score){
        this.score = score;

    }

    public String getTime(){
        return time;

    }

    public void setTime(String time){
        this.time = time;

    }
}
