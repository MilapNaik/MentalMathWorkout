package com.milapnaik.mentalmathworkout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.view.KeyEvent;

/**
 * Created by MilapNaik on 5/2/16.
 */
public class CountDown extends AppCompatActivity{
    public final static String DIFFICULTY = "com.milapnaik.mentalmathworkout.MESSAGE";
    CountDownTimer countDownTimer;
    TextView timer, test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final String testorpractice = extras.getString("TESTORPRACTICE");
        final String mathorseq = extras.getString("MATHORSEQ");

        timer = (TextView) findViewById(R.id.timer);
        test = (TextView) findViewById(R.id.test);

        timer.setTextSize(100);
        timer.setTextColor(Color.rgb(25, 4, 4));

        test.setTextSize(32);
        test.setTextColor(Color.rgb(25, 4, 4));

        if (mathorseq.equals("Seqtest")) {
            if(testorpractice.equals("Test")) {
                test.setText("Sequence Test");
            }
            else {
                test.setText("Sequence Practice");
            }
        }
        else{
            if(testorpractice.equals("Test")) {
                test.setText("Math Test");
            }
            else {
                test.setText("Math Practice");
            }

        }



        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf((int) millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                if (mathorseq.equals("Seqtest")) {
                    if(testorpractice.equals("Test")) {
                        Intent intent = new Intent(CountDown.this, SeqTest.class);
                        startActivity(intent); //Start Sequence test
                        finish();
                    }
                    else{
                        Intent intent = new Intent(CountDown.this, SeqPractice.class);
                        startActivity(intent); //Start Sequence practice
                        finish();
                    }

                }
                else if (mathorseq.equals("Mathtest")) {
                    if(testorpractice.equals("Test")) {
                        Intent intent = new Intent(CountDown.this, MathTest.class);
                        startActivity(intent); //Start Math test
                        finish();
                    }
                    else{
                        Intent intent = new Intent(CountDown.this, MathPractice.class);
                        startActivity(intent); //Start Math practice
                        finish();

                    }
                }
                else{
                    Intent intent = new Intent(CountDown.this, MainActivity.class);
                    startActivity(intent); //Go back to main activity
                }
                //timer.setText("GO");
            }
        }.start();


    }


    // Kill activity if countdown starts but back button is pressed
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {

            countDownTimer.cancel();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
