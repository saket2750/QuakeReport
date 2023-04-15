package com.android.customadapter;

public class QuakeReport {
    private final double magnitude;
    private final String state;
    private final long dateTime;
    private final String url;

    public QuakeReport(double magnitude, String state, long dateTime, String url){
        this.magnitude = magnitude;
        this.state = state;
        this.dateTime = dateTime;
        this.url = url;
    }

    public double getMagnitude(){
        return magnitude;
    }

    public String getState(){
        return state;
    }

    public long getDateTime(){
        return dateTime;
    }

    public String getUrl(){
        return url;
    }
}
