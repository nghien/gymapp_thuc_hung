package com.gymapp.gymapp.Model.DTO;

/**
 * Created by hungbin on 9/23/2016.
 */
public class ExerciseSchedule {
    private String name;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ExerciseSchedule(String name,String time){
        this.name = name;
        this.time = time;
    }
}
