package com.milapnaik.mentalmathworkout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import android.widget.Button;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import android.os.SystemClock;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Random;

/**
 * Created by MilapNaik on 3/18/16.
 */
public class MathTest extends AppCompatActivity {

    int i = 0;
    int rando;
    int qnumber = 1;
    int correctcount = 0;
    int n = 10; /*How many rows this test*/
    int qoutof=n/2;
    Question[] mathTest = new Question[80];
    long mStartTime, mEndTime, mTotalTime;
    String answer;
    public final static String NUM_CORRECT = "com.milapnaik.mentalmathworkout.MESSAGE";
    public final static String TIMER = "com.milapnaik.mentalmathworkout.MESSAGE";
    public static final String MyPREFERENCES = "MyPrefs" ;
    String Difficulty;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        final TextView mathProblem = (TextView) findViewById(R.id.mathProblem);
        final TextView mathAnswer = (TextView) findViewById(R.id.mathAnswer);
        final TextView qCount = (TextView) findViewById(R.id.qcount);


        //Styling for the question and answer text
        mathProblem.setTextSize(25);
        mathProblem.setTextColor(Color.WHITE);
        mathAnswer.setTextSize(25);
        mathAnswer.setTextColor(Color.WHITE);


        Intent gintent = getIntent();
        final String difficulty = gintent.getStringExtra(PracticeOrTest.DIFFICULTY);

        /*if(difficulty.equals("Practice"))
            n=20;
        else if (difficulty.equals("Test"))
            n=160;*/

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");

        //Try to read the problem and answers text file
        try {

            InputStream is = this.getResources().openRawResource(R.raw.easymath);
            if( Difficulty.equals("Hard")) {
                is = this.getResources().openRawResource(R.raw.easymath);
            }
            else if ( Difficulty.equals("Hard")) {
                is = this.getResources().openRawResource(R.raw.mediummath);
            }
            else {
                is = this.getResources().openRawResource(R.raw.hardmath);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            /*read in file to array*/
            for (i = 0; i < 80; i++) {
                mathTest[i] = new Question();
                if ((line = reader.readLine()) != null)
                    mathTest[i].setQuestion(line); //Enter in problem

                if ((line = reader.readLine()) != null)
                    mathTest[i].setAnswer(line); //Enter in solution
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        ShuffleArray(mathTest);
        i = 0;

        mathProblem.setText(mathTest[i].problem);
        qCount.setText(i+1 + "/" + n);
        mStartTime = System.currentTimeMillis();

        Button n1Button = (Button) findViewById(R.id.n1);
        n1Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "1");
            }

        });
        Button n2Button = (Button) findViewById(R.id.n2);
        n2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "2");
            }

        });
        Button n3Button = (Button) findViewById(R.id.n3);
        n3Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "3");
            }

        });
        Button n4Button = (Button) findViewById(R.id.n4);
        n4Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "4");
            }

        });
        Button n5Button = (Button) findViewById(R.id.n5);
        n5Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "5");
            }

        });
        Button n6Button = (Button) findViewById(R.id.n6);
        n6Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "6");
            }

        });
        Button n7Button = (Button) findViewById(R.id.n7);
        n7Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "7");
            }

        });
        Button n8Button = (Button) findViewById(R.id.n8);
        n8Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "8");
            }

        });
        Button n9Button = (Button) findViewById(R.id.n9);
        n9Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "9");
            }

        });
        Button n0Button = (Button) findViewById(R.id.n0);
        n0Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "0");
            }

        });
        Button nminusButton = (Button) findViewById(R.id.nminus);
        nminusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + "-");
            }

        });
        Button ndecimalButton = (Button) findViewById(R.id.ndecimal);
        ndecimalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText(answer + ".");
            }

        });
        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                answer = mathAnswer.getText().toString();
                mathAnswer.setText("");
            }

        });


        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                answer = mathAnswer.getText().toString();
                String correctAnswer = mathTest[i].answer;

                if (answer.equals(correctAnswer)) {
                    correctcount++;
                    mathAnswer.setText("");

                    Toast.makeText(MathTest.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MathTest.this,
                            correctAnswer,
                            Toast.LENGTH_SHORT).show();
                    mathAnswer.setText("");

                }
                i++ ;
                qCount.setText(i+1 + "/" + n);

                if (i  >= n ) {
                    mEndTime = System.currentTimeMillis();
                    mTotalTime = mEndTime - mStartTime;
                    int seconds = (int) (mTotalTime / 1000);
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    int millis = (int) mTotalTime % 1000;
                    String sectime = Integer.toString(seconds);
                    String milsectime = Integer.toString(millis);
                    String time = sectime + "." + milsectime;
                    Intent intent = new Intent(MathTest.this, FinishTest.class);
                    String count = Integer.toString(correctcount);

                    Bundle extras = new Bundle();
                    extras.putString("TIMER", time);
                    extras.putString("NUM_CORRECT",count);
                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();
                }

                if (i < n)
                    mathProblem.setText(mathTest[i].problem);
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


}
