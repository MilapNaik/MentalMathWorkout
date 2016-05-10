package com.milapnaik.mentalmathworkout;

/**
 * Created by MilapNaik on 5/10/16.
 */
public class LB {

    private String rank, name, score;

    public LB(String rank, String name, String score){
        this.setRank(rank);
        this.setName(name);
        this.setScore(score);
    }

    public String getRank(){
        return rank;

    }

    public void setRank(String rank){
        this.rank = rank;

    }

    public String getName(){
        return name;

    }

    public void setName(String name){
        this.name = name;

    }

    public String getScore(){
        return score;

    }

    public void setScore(String score){
        this.score = score;

    }
}
