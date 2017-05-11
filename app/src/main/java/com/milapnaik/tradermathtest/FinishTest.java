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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


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
    Boolean isTest;
    StringBuilder typeoftestdisplay = new StringBuilder();
    StringBuilder correctdisplay = new StringBuilder();
    StringBuilder timedisplay = new StringBuilder();
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    //Ad code
    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishtest);
        Intent intent = getIntent();
        Context ctx = this;

        // Ad
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Find correct answers, amount of time, and test type
        Bundle extras = intent.getExtras();
        correct = extras.getString("NUM_CORRECT");
        timed = extras.getString("TIMER");
        test_type = extras.getString("TEST_TYPE"); //Math or Seq

        // Find what difficulty and # of questions from the preferences
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);

        // Find out if this was a test or practice
        // (practice has 5,10 or 20 questions; test has either 50 or 80)
        isTest = sharedpreferences.getBoolean("Test", false);

        TextView test = (TextView) findViewById(R.id.test);
        test.setTextColor(Color.BLACK);
        test.setTextSize(32);

        if (isTest){
            if (test_type.equals("Seq")) {
                Questions = 50;
                test.setText("Sequence Test");
            }
            else {
                Questions = 80;
                test.setText("Math Test");
            }
        }
        else{
            if (test_type.equals("Seq")) {
                test.setText("Sequence Practice");
            }
            else {
                test.setText("Math Practice");
            }
        }


        TextView leaderboard = (TextView) findViewById(R.id.leaderboard);
        leaderboard.setTextColor(Color.BLACK);
        leaderboard.setTextSize(28);
        typeoftestdisplay.append(Questions);
        typeoftestdisplay.append(" ");
        typeoftestdisplay.append(Difficulty);
        typeoftestdisplay.append(" Questions");
        leaderboard.setText(typeoftestdisplay);

        TextView numcorrect = (TextView) findViewById(R.id.correct_count);
        numcorrect.setTextColor(Color.WHITE);
        numcorrect.setTextSize(25);
        correctdisplay.append("Correct answers: ");
        correctdisplay.append(correct);
        numcorrect.setText(correctdisplay);

        TextView time = (TextView) findViewById(R.id.time);
        time.setTextColor(Color.WHITE);
        time.setTextSize(25);
        timedisplay.append("Time: ");
        timedisplay.append(timed);
        time.setText(timedisplay);




        // Add new score to certain leaderboard
        if (test_type.equals("Seq")){

            switch (Difficulty) {
                case "Hard": {
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute("add_hsinfo", rank, correct, timed);
                    break;
                }
                case "Medium": {
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute("add_msinfo", rank, correct, timed);
                    break;
                }
                default: {
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute("add_esinfo", rank, correct, timed);
                    break;
                }
            }

        }
        else {
            switch (Difficulty) {
                case "Hard": {
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute("add_hminfo", rank, correct, timed);
                    break;
                }
                case "Medium": {
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute("add_mminfo", rank, correct, timed);
                    break;
                }
                default: {
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute("add_eminfo", rank, correct, timed);
                    break;
                }
            }
        }


        // Show top 5 scores of specified leaderboard
        if (test_type.equals("Seq")) {
            switch (Difficulty) {
                case "Hard": {
                    BackgroundTask backgroundTask = new BackgroundTask(ctx);
                    backgroundTask.execute("get_hsinfo");
                    break;
                }
                case "Medium": {
                    BackgroundTask backgroundTask = new BackgroundTask(ctx);
                    backgroundTask.execute("get_msinfo");
                    break;
                }
                default: {
                    BackgroundTask backgroundTask = new BackgroundTask(ctx);
                    backgroundTask.execute("get_esinfo");
                    break;
                }
            }
        }
        else {
            switch (Difficulty) {
                case "Hard": {
                    BackgroundTask backgroundTask = new BackgroundTask(ctx);
                    backgroundTask.execute("get_hminfo");
                    break;
                }
                case "Medium": {
                    BackgroundTask backgroundTask = new BackgroundTask(ctx);
                    backgroundTask.execute("get_mminfo");
                    break;
                }
                default: {
                    BackgroundTask backgroundTask = new BackgroundTask(ctx);
                    backgroundTask.execute("get_eminfo");
                    break;
                }
            }

        }
    }

    public void mainmenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
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
