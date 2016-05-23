package com.milapnaik.tradermathtest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import android.widget.Button;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by MilapNaik on 5/5/16.
 */
public class SeqTest extends AppCompatActivity {
    int i = 0;
    int correctcount = 0;
    StringBuilder questionCount = new StringBuilder();
    StringBuilder answer = new StringBuilder();

    Question[] mathTest = new Question[80];
    long mStartTime, mEndTime, mTotalTime;
    String Difficulty;
    int qcount = 1;
    final int n = 50;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public final static String NUM_CORRECT = "com.milapnaik.mentalmathworkout.MESSAGE";
    public final static String TIMER = "com.milapnaik.mentalmathworkout.MESSAGE";
    public final static String Practortest = "com.milapnaik.mentalmathworkout.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        final TextView mathProblem = (TextView) findViewById(R.id.mathProblem);
        final TextView mathAnswer = (TextView) findViewById(R.id.mathAnswer);
        final TextView qCount = (TextView) findViewById(R.id.qcount);


        //Styling for the question and answer text
        mathProblem.setTextSize(22);
        mathProblem.setTextColor(Color.WHITE);
        mathAnswer.setTextSize(22);
        mathAnswer.setTextColor(Color.WHITE);

        // Get the question amount and difficulty
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");

        //Try to read the problem and answers text file
        try {

            InputStream is;
            switch (Difficulty) {
                case "Hard":
                    is = this.getResources().openRawResource(R.raw.hardseq);
                    break;
                case "Medium":
                    is = this.getResources().openRawResource(R.raw.mediumseq);
                    break;
                default:
                    is = this.getResources().openRawResource(R.raw.easyseq);
                    break;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            /*read in file to array*/
            for (i = 0; i < 50; i++) {
                mathTest[i] = new Question();
                if ((line = reader.readLine()) != null)
                    mathTest[i].setQuestion(line); //Enter in problem

                if ((line = reader.readLine()) != null)
                    mathTest[i].setAnswer(line); //Enter in solution
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        // Shuffle array
        ShuffleArray(mathTest);
        i = 0;

        // Set first problem, problem number, and start time for timer
        mathProblem.setText(mathTest[i].problem);
        questionCount.append(i+1);
        questionCount.append("/");
        questionCount.append(n);
        qCount.setText(questionCount);
        mStartTime = System.currentTimeMillis();


        // Set up keypad
        Button n1Button = (Button) findViewById(R.id.n1);
        n1Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(1);
                mathAnswer.setText(answer);
            }

        });
        Button n2Button = (Button) findViewById(R.id.n2);
        n2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(2);
                mathAnswer.setText(answer);
            }

        });
        Button n3Button = (Button) findViewById(R.id.n3);
        n3Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(3);
                mathAnswer.setText(answer);
            }

        });
        Button n4Button = (Button) findViewById(R.id.n4);
        n4Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(4);
                mathAnswer.setText(answer);
            }

        });
        Button n5Button = (Button) findViewById(R.id.n5);
        n5Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(5);
                mathAnswer.setText(answer);
            }

        });
        Button n6Button = (Button) findViewById(R.id.n6);
        n6Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(6);
                mathAnswer.setText(answer);
            }

        });
        Button n7Button = (Button) findViewById(R.id.n7);
        n7Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(7);
                mathAnswer.setText(answer);
            }

        });
        Button n8Button = (Button) findViewById(R.id.n8);
        n8Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(8);
                mathAnswer.setText(answer);
            }
        });
        Button n9Button = (Button) findViewById(R.id.n9);
        n9Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(9);
                mathAnswer.setText(answer);
            }

        });
        Button n0Button = (Button) findViewById(R.id.n0);
        n0Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(0);
                mathAnswer.setText(answer);
            }

        });
        Button nminusButton = (Button) findViewById(R.id.nminus);
        nminusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append("-");
                mathAnswer.setText(answer);
            }

        });
        Button ndecimalButton = (Button) findViewById(R.id.ndecimal);
        ndecimalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.append(".");
                mathAnswer.setText(answer);
            }

        });
        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer.setLength(0);
                mathAnswer.setText(answer);
            }

        });

        // When enter is pressed, check if answer is correct and bring in
        // new question
        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                double answer2double= Double.NaN;
                if (answer.length() != 0)
                    answer2double = Double.parseDouble(answer.toString());
                String correctAnswer = mathTest[i].answer;
                double correctAnswer2double = Double.parseDouble(correctAnswer);

                //if answer is correct or correct answer begins with 0, leaving out 0 is acceptable
                if (answer2double == correctAnswer2double) {
                    correctcount++;
                    mathAnswer.setText("");

                    Toast.makeText(SeqTest.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SeqTest.this,
                            "Correct Answer: " + correctAnswer,
                            Toast.LENGTH_SHORT).show();
                    mathAnswer.setText("");
                }
                i++;

                if (i < n) {
                    qcount++;
                    questionCount.setLength(0);
                    questionCount.append(qcount);
                    questionCount.append("/");
                    questionCount.append(n);
                    qCount.setText(questionCount);
                    mathProblem.setText(mathTest[i].problem);
                }


                // If question number reaches set question amount, end test and
                // Calculate total time and number of questions correct and finish test
                if (i >= n) {
                    mEndTime = System.currentTimeMillis();
                    mTotalTime = mEndTime - mStartTime;
                    int seconds = (int) (mTotalTime / 1000);
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    int millis = (int) mTotalTime % 1000;
                    //String sectime = Integer.toString(seconds);
                    //String milsectime = Integer.toString(millis);
                    String time = String.format("%02d:%02d.%03d", minutes, seconds, millis);
                    Intent intent = new Intent(SeqTest.this, FinishTest.class);
                    String count = Integer.toString(correctcount);

                    Bundle extras = new Bundle();
                    extras.putString("TIMER", time);
                    extras.putString("NUM_CORRECT", count);
                    extras.putString("TEST_TYPE","Seq");
                    intent.putExtras(extras);

                    SharedPreferences preference = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putBoolean("Test", true);
                    editor.commit();

                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void ShuffleArray(Question[] array)
    {
        Question temp;
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Kill activity if back button pressed
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }



}

