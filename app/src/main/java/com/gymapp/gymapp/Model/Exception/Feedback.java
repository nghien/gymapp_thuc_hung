package com.gymapp.gymapp.Model.Exception;

/**
 * Created by hungbin on 9/23/2016.
 */
public class Feedback {
    public static Feedback getInstance() {
        return instance;
    }

    private static final Feedback instance = new Feedback();

    public Feedback(){

    }

    public void setFeedBackString(String errorStr){
        //feedback o day
    }
}
