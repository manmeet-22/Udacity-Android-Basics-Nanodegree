package com.androidexample.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidexample.habittracker.HabitContract.Habits;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HabitDbHelper db = new HabitDbHelper(this);

        Log.v("Query: ", Habits.CREATE_TABLE);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addHabitRow(new HabitDetails("Study", 1, "Daily", "2.5 hrs", 1));
        db.addHabitRow(new HabitDetails("Play", 1, "Daily", "2 hrs", 1));
        db.addHabitRow(new HabitDetails("Eating", 0, "Random", "5-10 min", 0));
        db.addHabitRow(new HabitDetails("Chatting", 1, "Daily", "1 hrs", 1));


        Cursor c = db.habitGetterMethod(2);
        HabitDetails HD = new HabitDetails(c.getString(1), Integer.parseInt(c.getString(2)), c.getString(3), c.getString(4), Integer.parseInt(c.getString(5)));
        // Reading all contacts
        Log.v("Update: ", HD.getHabitName() + " " + HD.getHabitValue() + " " + HD.getHabitFrequency() + " " + HD.getHabitTime() + " " + HD.getHabitGoal());

    }
}
