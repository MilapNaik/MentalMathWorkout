package com.milapnaik.mentalmathworkout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    String rank = "1";
    String Difficulty;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishtest);
        Intent intent = getIntent();
        Context ctx = this;

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


        // Find what difficulty this is
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");

        // Check if high score



        // Add to leaderboard
        if (Difficulty.equals("Hard")){
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute("add_hminfo", rank, correct, timed);
        }
        else if (Difficulty.equals("Medium")){
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute("add_mminfo", rank, correct, timed);
        }
        else {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute("add_eminfo", rank, correct, timed);
        }

        // Show high scores
        if (Difficulty.equals("Hard")){
            BackgroundTask backgroundTask = new BackgroundTask(ctx);
            backgroundTask.execute("get_hminfo");
        }
        else if (Difficulty.equals("Medium")){
            BackgroundTask backgroundTask = new BackgroundTask(ctx);
            backgroundTask.execute("get_mminfo");
        }
        else {
            BackgroundTask backgroundTask = new BackgroundTask(ctx);
            backgroundTask.execute("get_eminfo");
        }
    }
}
