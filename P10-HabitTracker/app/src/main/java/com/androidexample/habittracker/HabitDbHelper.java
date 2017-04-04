package com.androidexample.habittracker;

/**
 * Created by MANI on 3/2/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidexample.habittracker.HabitContract.Habits;

/**
 * Database helper for habit app. Manages database creation and version management.
 */


public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habit.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    Context context;

    /**
     * Constructs a new instance of {@link HabitDbHelper}.
     *
     * @param context of the app
     */
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute the SQL statement using the table command created in HabitContract class
        db.execSQL(Habits.CREATE_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //This function is called whenever we want to add,delete or update the database.
        db.execSQL(Habits.DELETE_TABLE);
        onCreate(db);
    }


    void addHabitRow(HabitDetails newHabit) {
        //Create a Database Connection
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Habits.HABIT_NAME, newHabit.getHabitName());
        values.put(Habits.HABIT_VALUE, newHabit.getHabitValue());
        values.put(Habits.HABIT_FREQUENCY, newHabit.getHabitFrequency());
        values.put(Habits.HABIT_TIME_GIVEN, newHabit.getHabitTime());
        values.put(Habits.HABIT_GOAL_ACHIEVED, newHabit.getHabitGoal());

        db.insert(Habits.TABLE_NAME, null, values); // Inserting Row
        db.close(); // Closing database connection
    }

    public Cursor habitGetterMethod(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {Habits.HABIT_ID,
                Habits.HABIT_NAME,
                Habits.HABIT_VALUE,
                Habits.HABIT_FREQUENCY,
                Habits.HABIT_TIME_GIVEN,
                Habits.HABIT_GOAL_ACHIEVED};

        String selection = Habits.HABIT_ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        //     Cursor cursor = db.query(Habits.TABLE_NAME, projection, selection,
        //          selectionArgs, null, null, null, null);
        Cursor cursor = db.query(Habits.TABLE_NAME, projection, null,
                null, null, null, null, null);


        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    // Update Values of Habit table row wise
    public void updateHabitRow(double rowId, String habitName, int habitValue, String habitFrequency, String habitTime, int habitGoal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Habits.HABIT_NAME, habitName);
        values.put(Habits.HABIT_VALUE, habitValue);
        values.put(Habits.HABIT_FREQUENCY, habitFrequency);
        values.put(Habits.HABIT_TIME_GIVEN, habitTime);
        values.put(Habits.HABIT_GOAL_ACHIEVED, habitGoal);
        db.update(Habits.TABLE_NAME, values, Habits.HABIT_ID + "=" + rowId, null);

    }

    // Deleting single habit from the table
    public void deleteHabitRow(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + Habits.TABLE_NAME + "where" + Habits.HABIT_ID + "=?" + id);
    }

}
