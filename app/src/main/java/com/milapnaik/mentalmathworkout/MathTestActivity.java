package com.milapnaik.mentalmathworkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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

/**
 * Created by MilapNaik on 3/18/16.
 */
public class MathTestActivity extends AppCompatActivity {

    int i = 0;
    int correctcount = 0;
    int n = 6; /*How many rows this test*/
    String[] mathTest = new String[40];
    long mStartTime, mEndTime, mTotalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        final TextView mathProblem = (TextView) findViewById(R.id.mathProblem);
        final EditText mathAnswer = (EditText) findViewById(R.id.mathAnswer);

        //Styling for the question text
        mathProblem.setTextSize(20);
        mathProblem.setTextColor(Color.rgb(0, 0, 0));




        //Try to read the problem and answers text file
        try {
            InputStream is = this.getResources().openRawResource(R.raw.easymath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            /*read in file to array*/
            for (i = 0; i < n; i=i+2) {
                //Question[] mediumTest = new Question[n];
                if ((line = reader.readLine()) != null)
                    mathTest[i] = line; //Enter in problem
                    //mediumTest[i].problem = line;

                if ((line = reader.readLine()) != null)
                    mathTest[i+1] = line; //Enter in solution
                    //mediumTest[i+1].answer = line;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        i = 0;

        mathProblem.setText(mathTest[0]);
        mStartTime = System.currentTimeMillis();

        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick(View view) {


                    String answer = mathAnswer.getText().toString();
                    String correctAnswer = mathTest[i+1];

                    if (answer.equals(correctAnswer)){
                        correctcount++;

                        Toast.makeText(MathTestActivity.this,
                                        R.string.correct_toast,
                                        Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(MathTestActivity.this,
                                        correctAnswer,
                                        Toast.LENGTH_SHORT).show();

                    }
                    i = i + 2;
                    mathProblem.setText(mathTest[i]);

                    if (i == n){
                        mathProblem.setTextSize(15);
                        mEndTime = System.currentTimeMillis();
                        mTotalTime = mEndTime - mStartTime;
                        int seconds = (int) (mTotalTime / 1000);
                        int minutes = seconds / 60;
                        seconds     = seconds % 60;
                        int millis = (int) mTotalTime % 1000;
                        String sectime = Integer.toString(seconds);
                        String milsectime = Integer.toString(millis);
                        String time = sectime + "." + milsectime;
                        mathProblem.setText(time);
                    }

            }

        });

    }
}
