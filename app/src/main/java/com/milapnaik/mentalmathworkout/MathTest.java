package com.milapnaik.mentalmathworkout;

import android.content.Intent;
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

/**
 * Created by MilapNaik on 3/18/16.
 */
public class MathTest extends AppCompatActivity {

    int i = 0;
    int correctcount = 0;
    int n = 40; /*How many rows this test*/
    String[] mathTest = new String[40];
    long mStartTime, mEndTime, mTotalTime;
    String answer;
    public final static String NUM_CORRECT = "com.milapnaik.mentalmathworkout.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        final TextView mathProblem = (TextView) findViewById(R.id.mathProblem);
        final TextView mathAnswer = (TextView) findViewById(R.id.mathAnswer);
        final TextView qCount = (TextView) findViewById(R.id.qcount);


        //Styling for the question text
        mathProblem.setTextSize(20);
        mathProblem.setTextColor(Color.rgb(0, 0, 0));

        Intent gintent = getIntent();
        final String difficulty = gintent.getStringExtra(PracticeOrTest.DIFFICULTY);

        if(difficulty.equals("Practice"))
            n=20;
        else if (difficulty.equals("Test"))
            n=160;


        //Try to read the problem and answers text file
        try {
            InputStream is = this.getResources().openRawResource(R.raw.easymath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            /*read in file to array*/
            for (i = 0; i < n; i = i + 2) {
                //Question[] mediumTest = new Question[n];
                if ((line = reader.readLine()) != null)
                    mathTest[i] = line; //Enter in problem
                //mediumTest[i].problem = line;

                if ((line = reader.readLine()) != null)
                    mathTest[i + 1] = line; //Enter in solution
                //mediumTest[i+1].answer = line;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        i = 0;

        mathProblem.setText(mathTest[0]);
        qCount.setText("1/80");
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


        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                answer = mathAnswer.getText().toString();
                String correctAnswer = mathTest[i + 1];

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
                i = i + 2;
                mathProblem.setText(mathTest[i]);
                qCount.setText(i+1 + "/80");

                if (i <= n) {
                    mathProblem.setTextSize(15);
                    mEndTime = System.currentTimeMillis();
                    mTotalTime = mEndTime - mStartTime;
                    int seconds = (int) (mTotalTime / 1000);
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    int millis = (int) mTotalTime % 1000;
                    String sectime = Integer.toString(seconds);
                    String milsectime = Integer.toString(millis);
                    String time = sectime + "." + milsectime;
                    mathProblem.setText(time + " seconds");
                    Intent intent = new Intent(MathTest.this, FinishTest.class);
                    String count = Integer.toString(correctcount);
                    intent.putExtra(NUM_CORRECT, count);
                    startActivity(intent);

                }

            }

        });
    }


}
