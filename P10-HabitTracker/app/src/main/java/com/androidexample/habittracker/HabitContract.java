package com.androidexample.habittracker;

import android.provider.BaseColumns;

/**
 * Created by MANI on 3/7/2017.
 */


public final class HabitContract {

    // To return a empty constructor to prevent someone from accidentally instantiating the contract class
    private HabitContract() {
    }

    public static final class Habits implements BaseColumns {

        public static final String TABLE_NAME = "habit"; //Table Name
        public static final String HABIT_ID = "id"; //Table Attributes
        public static final String HABIT_NAME = "name"; //Habit Name
        public static final String HABIT_VALUE = "value"; //Is the habit Good or Bad. '0' for BAD and '1' for GOOD
        public static final String HABIT_FREQUENCY = "frequency"; //Do we do it regularly,weekends or randomly
        public static final String HABIT_TIME_GIVEN = "time_given"; //Hours given to this habit
        public static final String HABIT_GOAL_ACHIEVED = "goal_achieved"; //Was the Activity done or not. '0' for NO and '1' for YES
        ;


        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                HABIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                HABIT_NAME + " TEXT NOT NULL, " +
                HABIT_VALUE + " INTEGER, " +
                HABIT_FREQUENCY + " TEXT NOT NULL, " +
                HABIT_TIME_GIVEN + " TEXT , " +
                HABIT_GOAL_ACHIEVED + " INTEGER NOT NULL " +
                " )";

        public static final String DELETE_TABLE = "DROP TABLE  " + TABLE_NAME;
    }
}