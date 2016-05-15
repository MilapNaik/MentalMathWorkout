package com.milapnaik.tradermathtest;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.widget.ToggleButton;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


/**
 * Created by MilapNaik on 5/5/16.
 */
public class Leaderboard extends AppCompatActivity {

    private DatabaseOperations DBop;
    ToggleButton math, seq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        Button easy, medium, hard;

        math = (ToggleButton) findViewById(R.id.mathToggle);
        seq = (ToggleButton) findViewById(R.id.seqToggle);

        easy = (Button) findViewById(R.id.easybutton);
        medium = (Button) findViewById(R.id.mediumbutton);
        hard = (Button) findViewById(R.id.hardbutton);

        math.setOnCheckedChangeListener(changeChecker);
        seq.setOnCheckedChangeListener(changeChecker);

        Context ctx = this;


        BackgroundTask backgroundTask = new BackgroundTask(ctx);
        backgroundTask.execute("get_eminfo");

    }

    OnCheckedChangeListener changeChecker = new OnCheckedChangeListener() {
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            if (buttonView != math) {
                math.setChecked(false);
            }
            if (buttonView != seq) {
                seq.setChecked(false);
            }
        }
    }
    };

}