package com.milapnaik.mentalmathworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by MilapNaik on 4/30/16.
 */
public class FinishTest extends AppCompatActivity{
    public String correct = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishtest);
        Intent intent = getIntent();

        correct = intent.getStringExtra(MathTest.NUM_CORRECT);

        TextView numcorrect = (TextView) findViewById(R.id.correct_count);
        numcorrect.setText(correct);
    }
}
