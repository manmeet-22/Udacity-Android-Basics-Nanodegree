package com.androidexample.habittracker;

/**
 * Created by MANI on 3/7/2017.
 */

public class HabitDetails {

    private int mHabitID;
    private String mHabitName;
    private int mHabitValue;
    private String mHabitFrequency;
    private String mHabitTime;
    private int mHabitGoal;

    public HabitDetails() {

    }

    public HabitDetails(String habitName, int habitValue, String habitFrequency, String habitTime, int habitGoal) {
        mHabitName = habitName;
        mHabitValue = habitValue;
        mHabitFrequency = habitFrequency;
        mHabitTime = habitTime;
        mHabitGoal = habitGoal;
    }

    //Getters and Setters

    public int getHabitId() {
        return mHabitID;
    }

    public void setHabitId(int id) {
        mHabitID = id;
    }

    public String getHabitName() {
        return mHabitName;
    }

    public void setHabitName(String name) {
        mHabitName = name;
    }

    public int getHabitValue() {
        return mHabitValue;
    }

    public void setHabitValue(int value) {
        mHabitValue = value;
    }

    public String getHabitFrequency() {
        return mHabitFrequency;
    }

    public void setHabitFrequency(String freq) {
        mHabitFrequency = freq;
    }

    public String getHabitTime() {
        return mHabitTime;
    }

    public void setHabitTime(String time) {
        mHabitTime = time;
    }

    public int getHabitGoal() {
        return mHabitGoal;
    }

    public void setHabitGoal(int goal) {
        mHabitGoal = goal;
    }

}

