package com.androidexample.logicbuilder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int total = 0;
    int f1 = 0;
    int f2 = 0;
    int f3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submit(View view) {

        RadioButton ans1_4 = (RadioButton) findViewById(R.id.q_1_4);
        if (ans1_4.isChecked()) {
            total++;
        }

        RadioButton ans2_3 = (RadioButton) findViewById(R.id.q_2_3);
        if (ans2_3.isChecked()) {
            total++;
        }

        RadioButton ans3_1 = (RadioButton) findViewById(R.id.q_3_1);
        if (ans3_1.isChecked()) {
            total++;
        }

        RadioButton ans4_1 = (RadioButton) findViewById(R.id.q_4_1);
        if (ans4_1.isChecked()) {
            total++;
        }

        CheckBox ans8_1 = (CheckBox) findViewById(R.id.q_8_1);
        CheckBox ans8_2 = (CheckBox) findViewById(R.id.q_8_2);
        CheckBox ans8_3 = (CheckBox) findViewById(R.id.q_8_3);
        CheckBox ans8_4 = (CheckBox) findViewById(R.id.q_8_4);
        if (ans8_2.isChecked() && ans8_4.isChecked() && !ans8_1.isChecked() && !ans8_3.isChecked()) {
            total++;
        }

        CheckBox ans9_1 = (CheckBox) findViewById(R.id.q_9_1);
        CheckBox ans9_2 = (CheckBox) findViewById(R.id.q_9_2);
        CheckBox ans9_3 = (CheckBox) findViewById(R.id.q_9_3);
        CheckBox ans9_4 = (CheckBox) findViewById(R.id.q_9_4);
        if (ans9_2.isChecked() && !ans9_1.isChecked() && !ans9_3.isChecked() && !ans9_4.isChecked()) {
            total++;
        }

        CheckBox ans10_1 = (CheckBox) findViewById(R.id.q_10_1);
        CheckBox ans10_2 = (CheckBox) findViewById(R.id.q_10_2);
        CheckBox ans10_3 = (CheckBox) findViewById(R.id.q_10_3);
        CheckBox ans10_4 = (CheckBox) findViewById(R.id.q_10_4);
        if (ans10_4.isChecked() && !ans10_1.isChecked() && !ans10_2.isChecked() && !ans10_3.isChecked()) {
            total++;
        }

        EditText ans5 = (EditText) findViewById(R.id.q_5_ans);
        String ans5string = ans5.getText().toString().toUpperCase();
        if (ans5string.equals("SLEEP")) {
            total++;
        }

        EditText ans6 = (EditText) findViewById(R.id.q_6_ans);
        String ans6string = ans6.getText().toString();
        if (ans6string.equals("10")) {
            total++;
        }

        EditText ans7 = (EditText) findViewById(R.id.q_7_ans);
        String ans7string = ans7.getText().toString();
        if (ans7string.equals("383")) {
            total++;
        }

        Context context = getApplicationContext();
        CharSequence text1 = "Your Score is " + total + " out of 10";
        CharSequence text2 = "Please Reset and Try Again";
        int duration = Toast.LENGTH_SHORT;
        if (total <= 10)
        {
            Toast toast = Toast.makeText(context, text1, duration);
            toast.show();
            total = 0;
        } else

        {
            Toast toast = Toast.makeText(context, text2, duration);
            toast.show();
            total = 0;
        }
    }

    public void reset(View view) {
        total = 0;
        RadioGroup radioGroup_1 = (RadioGroup) findViewById(R.id.q_1_radioGroup);
        radioGroup_1.clearCheck();

        RadioGroup radioGroup_2 = (RadioGroup) findViewById(R.id.q_2_radioGroup);
        radioGroup_2.clearCheck();

        RadioGroup radioGroup_3 = (RadioGroup) findViewById(R.id.q_3_radioGroup);
        radioGroup_3.clearCheck();

        RadioGroup radioGroup_4 = (RadioGroup) findViewById(R.id.q_4_radioGroup);
        radioGroup_4.clearCheck();

        EditText q5ans = (EditText) findViewById(R.id.q_5_ans);
        q5ans.setText(null);

        EditText q6ans = (EditText) findViewById(R.id.q_6_ans);
        q6ans.setText(null);

        EditText q7ans = (EditText) findViewById(R.id.q_7_ans);
        q7ans.setText(null);

        CheckBox checkBox_8_1 = (CheckBox) findViewById(R.id.q_8_1);
        CheckBox checkBox_8_2 = (CheckBox) findViewById(R.id.q_8_2);
        CheckBox checkBox_8_3 = (CheckBox) findViewById(R.id.q_8_3);
        CheckBox checkBox_8_4 = (CheckBox) findViewById(R.id.q_8_4);
        checkBox_8_1.setChecked(false);
        checkBox_8_2.setChecked(false);
        checkBox_8_3.setChecked(false);
        checkBox_8_4.setChecked(false);

        CheckBox checkBox_9_1 = (CheckBox) findViewById(R.id.q_9_1);
        CheckBox checkBox_9_2 = (CheckBox) findViewById(R.id.q_9_2);
        CheckBox checkBox_9_3 = (CheckBox) findViewById(R.id.q_9_3);
        CheckBox checkBox_9_4 = (CheckBox) findViewById(R.id.q_9_4);
        checkBox_9_1.setChecked(false);
        checkBox_9_2.setChecked(false);
        checkBox_9_3.setChecked(false);
        checkBox_9_4.setChecked(false);

        CheckBox checkBox_10_1 = (CheckBox) findViewById(R.id.q_10_1);
        CheckBox checkBox_10_2 = (CheckBox) findViewById(R.id.q_10_2);
        CheckBox checkBox_10_3 = (CheckBox) findViewById(R.id.q_10_3);
        CheckBox checkBox_10_4 = (CheckBox) findViewById(R.id.q_10_4);
        checkBox_10_1.setChecked(false);
        checkBox_10_2.setChecked(false);
        checkBox_10_3.setChecked(false);
        checkBox_10_4.setChecked(false);

    }

}



