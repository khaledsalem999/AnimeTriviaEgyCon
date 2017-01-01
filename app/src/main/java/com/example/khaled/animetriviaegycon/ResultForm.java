package com.example.khaled.animetriviaegycon;

import java.util.ArrayList;

/**
 * Created by hyhae on 1/1/2017.
 */

public class ResultForm {
    private String UserID;
    private String firstName;
    private String lastName;
    private int CorrectAnswers;
    private int WrongAnswers;
    private long TimeInMillis;

    public ResultForm(String userID, String firstName, String lastName, int correctAnswers, int wrongAnswers, long timeInMillis) {
        UserID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        CorrectAnswers = correctAnswers;
        WrongAnswers = wrongAnswers;
        TimeInMillis = timeInMillis;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCorrectAnswers() {
        return CorrectAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        CorrectAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return WrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        WrongAnswers = wrongAnswers;
    }

    public long getTimeInMillis() {
        return TimeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        TimeInMillis = timeInMillis;
    }
}
