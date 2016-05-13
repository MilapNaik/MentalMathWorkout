package com.milapnaik.mentalmathworkout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;


/**
 * Created by MilapNaik on 4/30/16.
 */
public class FinishTest extends AppCompatActivity{
    public String correct = "0";
    public String timed = "0";
    public String test_type = "";
    String rank = "1";
    String Difficulty;
    int Questions;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishtest);
        Intent intent = getIntent();
        Context ctx = this;

        // Find correct answers, amount of time, and test type
        Bundle extras = intent.getExtras();
        correct = extras.getString("NUM_CORRECT");
        timed = extras.getString("TIMER");
        test_type = extras.getString("TEST_TYPE");

        // Find what difficulty from the preferences
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);


        TextView leaderboard = (TextView) findViewById(R.id.leaderboard);
        leaderboard.setTextColor(Color.BLACK);
        leaderboard.setTextSize(25);
        leaderboard.setText(Questions + " " + Difficulty + " Leaderboard");

        TextView numcorrect = (TextView) findViewById(R.id.correct_count);
        numcorrect.setTextColor(Color.WHITE);
        numcorrect.setTextSize(25);
        numcorrect.setText(correct + " questions correct");

        TextView time = (TextView) findViewById(R.id.time);
        time.setTextColor(Color.WHITE);
        time.setTextSize(25);
        time.setText("Time: " + timed);




        // Add to specific leaderboard
        if (test_type.equals("Seq")){
            if (Difficulty.equals("Hard")) {
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_hsinfo", rank, correct, timed);
            } else if (Difficulty.equals("Medium")) {
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_msinfo", rank, correct, timed);
            } else {
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_esinfo", rank, correct, timed);
            }

        }
        else {
            if (Difficulty.equals("Hard")) {
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_hminfo", rank, correct, timed);
            } else if (Difficulty.equals("Medium")) {
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_mminfo", rank, correct, timed);
            } else {
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute("add_eminfo", rank, correct, timed);
            }
        }


        // Show top 5 scores
        if (test_type.equals("Seq")) {
            if (Difficulty.equals("Hard")) {
                BackgroundTask backgroundTask = new BackgroundTask(ctx);
                backgroundTask.execute("get_hsinfo");
            } else if (Difficulty.equals("Medium")) {
                BackgroundTask backgroundTask = new BackgroundTask(ctx);
                backgroundTask.execute("get_msinfo");
            } else {
                BackgroundTask backgroundTask = new BackgroundTask(ctx);
                backgroundTask.execute("get_esinfo");
            }
        }
        else {
            if (Difficulty.equals("Hard")) {
                BackgroundTask backgroundTask = new BackgroundTask(ctx);
                backgroundTask.execute("get_hminfo");
            } else if (Difficulty.equals("Medium")) {
                BackgroundTask backgroundTask = new BackgroundTask(ctx);
                backgroundTask.execute("get_mminfo");
            } else {
                BackgroundTask backgroundTask = new BackgroundTask(ctx);
                backgroundTask.execute("get_eminfo");
            }

        }
    }

    public void mainmenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
