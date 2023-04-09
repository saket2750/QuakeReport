package com.android.customadapter;

public class QuakeReport {
    private float magnitude;
    private String state;
    private String dateTime;

    public QuakeReport(float magnitude, String state, String dateTime){
        this.magnitude = magnitude;
        this.state = state;
        this.dateTime = dateTime;
    }

    public float getMagnitude(){
        return magnitude;
    }

    public String getState(){
        return state;
    }

    public String getDateTime(){
        return dateTime;
    }

}
