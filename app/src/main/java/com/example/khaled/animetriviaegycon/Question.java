package com.example.khaled.animetriviaegycon;

import java.io.Serializable;

/**
 * Created by hyhae on 1/1/2017.
 */

public class Question implements Serializable {
    private String anime;
    private String question;
    private String correctAns;
    private String secAns;
    private String thirdAns;
    private String picUrl;
    private int Score;

    public Question(String anime, String question, String correctAns, String secAns, String thirdAns, String picUrl) {
        this.anime = anime;
        this.question = question;
        this.correctAns = correctAns;
        this.secAns = secAns;
        this.thirdAns = thirdAns;
        this.picUrl = picUrl;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getSecAns() {
        return secAns;
    }

    public void setSecAns(String secAns) {
        this.secAns = secAns;
    }

    public String getThirdAns() {
        return thirdAns;
    }

    public void setThirdAns(String thirdAns) {
        this.thirdAns = thirdAns;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getScore() {return Score;}

    public void setScore(int score) {Score = score;}
}
