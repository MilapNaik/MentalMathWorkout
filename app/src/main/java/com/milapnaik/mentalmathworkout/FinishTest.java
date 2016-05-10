package com.milapnaik.mentalmathworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.graphics.Color;


/**
 * Created by MilapNaik on 4/30/16.
 */
public class FinishTest extends AppCompatActivity{
    public String correct = "0";
    public String timed = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishtest);
        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        correct = extras.getString("NUM_CORRECT");
        timed = extras.getString("TIMER");

        TextView numcorrect = (TextView) findViewById(R.id.correct_count);
        numcorrect.setTextColor(Color.WHITE);
        numcorrect.setTextSize(25);
        numcorrect.setText(correct + " questions correct");

        TextView time = (TextView) findViewById(R.id.time);
        time.setTextColor(Color.WHITE);
        time.setTextSize(25);
        time.setText("Time: " + timed);

        // Check for high scores

    }
}
