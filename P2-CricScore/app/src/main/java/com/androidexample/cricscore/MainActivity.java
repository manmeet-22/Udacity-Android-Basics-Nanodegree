package com.androidexample.cricscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int f1;
    int f2;
    int f3;
    int totalOvers;
    int scoreA = 0;
    int overA = 0;
    int ballA = 0;
    int wicketA = 0;
    int wideA = 0;
    int noballA = 0;
    int legbyeA = 0;
    int dotA = 0;
    int scoreB = 0;
    int overB = 0;
    int ballB = 0;
    int wicketB = 0;
    int wideB = 0;
    int noballB = 0;
    int legbyeB = 0;
    int dotB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button names = (Button) findViewById(R.id.start);
        assert names != null;
        names.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText getNameA = (EditText) findViewById(R.id.firstTeamName);
                TextView setNameA = (TextView) findViewById(R.id.teamOneMainName);
                TextView setRadioNameA = (TextView) findViewById(R.id.teamOneRadioName);

                EditText getNameB = (EditText) findViewById(R.id.secondTeamName);
                TextView setNameB = (TextView) findViewById(R.id.teamTwoMainName);
                TextView setRadioNameB = (TextView) findViewById(R.id.teamTwoRadioName);

                EditText ovT = (EditText) findViewById(R.id.tOvers);
                TextView ovA = (TextView) findViewById(R.id.tOvers1);
                TextView ovB = (TextView) findViewById(R.id.tOvers2);


                String str1 = getNameA.getText().toString();

                if (TextUtils.isEmpty(str1)) {
                    f1 = 0;
                    getNameA.setError("Please Enter First Team Name");
                }
                else {
                    f1 = 1;
                }

                String str2 = getNameB.getText().toString();

                if (TextUtils.isEmpty(str2)) {
                    f2 = 0;
                    getNameB.setError("Please Enter Second Team Name");
                }
                else {
                    f2 = 1;
                }

                String strOver = ovT.getText().toString();

                if (TextUtils.isEmpty(strOver)) {
                    f3 = 0;
                    ovT.setError("Please Enter the Number of Overs");
                    return;
                }
                else {
                    f3 = 1;
                }

                totalOvers = Integer.parseInt(ovT.getText().toString());

                if (f1 == 1 && f2 == 1 && f3 == 1) {
                    setNameA.setText(getNameA.getText().toString());
                    setRadioNameA.setText(getNameA.getText().toString());

                    setNameB.setText(getNameB.getText().toString());
                    setRadioNameB.setText(getNameB.getText().toString());

                    ovA.setText("/" + ovT.getText().toString() + ".0");
                    ovB.setText("/" + ovT.getText().toString() + ".0");

                }
                else if (f1 == 0 || f2 == 0 || f3 == 0) {
                }
            }
        }
        );
    }

    public void result(View view) {
        RadioGroup r1 = (RadioGroup) findViewById(R.id.tossRadioGroup);
        int tossId = r1.getCheckedRadioButtonId();
        //boolean checked = ((RadioButton) view).isChecked();

        switch (tossId) {
            case R.id.teamOneRadio:

                displayRadioForTeamA("Won Toss and chose to ");
                displayRadioForTeamB("Lost Toss and will ");

                RadioGroup r = (RadioGroup) findViewById(R.id.playRadioGroup);
                int id = r.getCheckedRadioButtonId();
                //boolean check = ((RadioButton) view).isChecked();

                switch (id) {
                    case R.id.chooseToBat:
                        displayPlayForTeamA("Bat");
                        displayPlayForTeamB("Bowl");
                        break;
                    case R.id.chooseToBowl:
                        displayPlayForTeamA("Bowl");
                        displayPlayForTeamB("Bat");
                        break;
                }
                break;
            case R.id.teamTwoRadio:
                displayRadioForTeamB("Won Toss and chose to ");
                displayRadioForTeamA("Lost Toss and is goin to ");

                RadioGroup r2 = (RadioGroup) findViewById(R.id.playRadioGroup);
                int id2 = r2.getCheckedRadioButtonId();
                //boolean check1 = ((RadioButton) view).isChecked();

                switch (id2) {
                    case R.id.chooseToBat:
                        displayPlayForTeamB("Bat");
                        displayPlayForTeamA("Bowl");
                        break;

                    case R.id.chooseToBowl:
                        displayPlayForTeamB("Bowl");
                        displayPlayForTeamA("Bat");
                        break;
                }
                break;
        }
    }


    public void aOne(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 1;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                }
                else {
                    displayForTeamA(scoreA + "/" + wicketA);
                    displayOverForTeamA(overA + "." + ballA);
                }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
            }
        }

    public void aTwo(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 2;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                }
                else {
                    displayForTeamA(scoreA + "/" + wicketA);
                    displayOverForTeamA(overA + "." + ballA);
                }
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }

    public void aThree(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 3;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
                else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                }
             }
            else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aFour(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 4;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aFive(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 5;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aSix(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 1;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aDot(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                ballA = ballA + 1;
                dotA = dotA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                displayDotForTeamA(dotA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aWide(View view) {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 1;
                wideA = wideA + 1;
                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                displayWideForTeamA(wideA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aNoball(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                scoreA = scoreA + 1;
                noballA = noballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                displayNoballForTeamA(noballA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aLegbye(View view)

    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                ballA = ballA + 1;
                legbyeA = legbyeA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                displayLegbyeForTeamA(legbyeA);
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void aWicket(View view)
    {
        if (wicketA < 10) {
            if (overA < totalOvers) {
                wicketA = wicketA + 1;
                ballA = ballA + 1;

                if (ballA == 6) {
                    ballA = 0;
                    overA = overA + 1;
                }
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
                return;
            }
            else {
                displayForTeamA(scoreA + "/" + wicketA);
                displayOverForTeamA(overA + "." + ballA);
            }
        }
        else {
            displayForTeamA(scoreA + "/" + wicketA);
            displayOverForTeamA(overA + "." + ballA);
        }
    }

    public void displayDotForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.aDotDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamOne);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWicketForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamOne);
        scoreView.setText(String.valueOf(score));
    }

    public void displayOverForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.overs1);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWideForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.awideDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayNoballForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.anoballDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayLegbyeForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.alegbyeDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRadioForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.teamOneMainRadio);
        scoreView.setText(String.valueOf(score));
    }


    public void displayRadioForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.teamTwoMainRadio);
        scoreView.setText(String.valueOf(score));
    }

    public void displayPlayForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.teamOneMainPlay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayPlayForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.teamTwoMainPlay);
        scoreView.setText(String.valueOf(score));
    }


    public void bOne(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 1;
                ballB = ballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bTwo(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 2;
                ballB = ballB + 1;
                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bThree(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 3;
                ballB = ballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bFour(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 4;
                ballB = ballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bFive(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 5;
                ballB = ballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        } else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bSix(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 1;
                ballB = ballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bDot(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                ballB = ballB + 1;
                dotB = dotB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;

                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
                displayDotForTeamB(dotB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        } else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bWide(View view) {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 1;
                wideB = wideB + 1;
                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
                displayWideForTeamB(wideB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);

            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bNoball(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                scoreB = scoreB + 1;
                noballB = noballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
                displayNoballForTeamB(noballB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bLegbye(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                ballB = ballB + 1;
                legbyeB = legbyeB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
                displayLegbyeForTeamB(legbyeB);
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }
        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void bWicket(View view)

    {
        if (wicketB < 10) {
            if (overB < totalOvers) {
                wicketB = wicketB + 1;
                ballB = ballB + 1;

                if (ballB == 6) {
                    ballB = 0;
                    overB = overB + 1;
                }
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
                return;
            }
            else {
                displayForTeamB(scoreB + "/" + wicketB);
                displayOverForTeamB(overB + "." + ballB);
            }

        }
        else {
            displayForTeamB(scoreB + "/" + wicketB);
            displayOverForTeamB(overB + "." + ballB);
        }
    }

    public void displayDotForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.bDotDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamTwo);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWicketForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamTwo);
        scoreView.setText(String.valueOf(score));
    }

    public void displayOverForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.overs2);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWideForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.bwideDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayNoballForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.bnoballDisplay);
        scoreView.setText(String.valueOf(score));
    }

    public void displayLegbyeForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.blegbyeDisplay);
        scoreView.setText(String.valueOf(score));
    }


    public void reset(View view) {
        displayPlayForTeamA("Bat/Bowl");
        displayWideForTeamA(0);
        displayWicketForTeamA("");
        displayForTeamA("0/0");
        displayNoballForTeamA(0);
        displayLegbyeForTeamA(0);
        displayDotForTeamA(0);
        displayOverForTeamA("0.0");
        displayRadioForTeamA("Won/Loss Toss and Chose to ");
        scoreA = 0;
        overA = 0;
        ballA = 0;
        wicketA = 0;
        wideA = 0;
        noballA = 0;
        legbyeA = 0;
        dotA = 0;
        totalOvers = 0;
        displayWideForTeamB(0);
        displayWicketForTeamB("");
        displayForTeamB("0/0");
        displayNoballForTeamB(0);
        displayLegbyeForTeamB(0);
        displayDotForTeamB(0);
        displayOverForTeamB("0.0");
        displayRadioForTeamB("Won/Loss Toss and Chose to ");
        displayPlayForTeamB("Bat/Bowl");
        scoreB = 0;
        overB = 0;
        ballB = 0;
        wicketB = 0;
        wideB = 0;
        noballB = 0;
        legbyeB = 0;
        dotB = 0;
        TextView setNameA = (TextView) findViewById(R.id.teamOneMainName);
        TextView setRadioNameA = (TextView) findViewById(R.id.teamOneRadioName);
        TextView ovA = (TextView) findViewById(R.id.tOvers1);
        TextView ovB = (TextView) findViewById(R.id.tOvers2);
        TextView setNameB = (TextView) findViewById(R.id.teamTwoMainName);
        TextView setRadioNameB = (TextView) findViewById(R.id.teamTwoRadioName);
        EditText getNameA = (EditText) findViewById(R.id.firstTeamName);
        EditText getNameB = (EditText) findViewById(R.id.secondTeamName);
        EditText ovT = (EditText) findViewById(R.id.tOvers);
        setNameA.setText("Team One");
        setRadioNameA.setText("Team One");
        setNameB.setText("Team Two");
        setRadioNameB.setText("Team Two");
        getNameA.setText(null);
        getNameB.setText(null);
        ovT.setText(null);
        ovA.setText("");
        ovB.setText("");
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tossRadioGroup);
        radioGroup.clearCheck();
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.playRadioGroup);
        radioGroup2.clearCheck();
        f1 = 0;
        f2 = 0;
        f3 = 0;
        getNameA.setError(null);
        getNameB.setError(null);
        ovT.setError(null);
    }

    public void exit(View view) {
        System.exit(0);
    }
}
