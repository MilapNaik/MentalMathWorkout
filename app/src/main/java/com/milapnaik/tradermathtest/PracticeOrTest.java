package com.milapnaik.tradermathtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by MilapNaik on 5/6/16.
 */

public class PracticeOrTest extends AppCompatActivity {
    public final static String TEST_TYPE = "com.milapnaik.mentalmathworkout.MESSAGE";
    public final static String DIFFICULTY = "com.milapnaik.mentalmathworkout.MESSAGE";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pot);


        }

    public void MathTestPractice(View view) {
        Intent gintent = getIntent();
        final String test = gintent.getStringExtra(MainActivity.TEST_TYPE);
        Intent intent = new Intent(this, CountDown.class);
        String testorpractice = "Practice";

        Bundle extras = new Bundle();
        extras.putString("TESTORPRACTICE", testorpractice);
        extras.putString("MATHORSEQ", test);
        intent.putExtras(extras);
        startActivity(intent);
        finish();
    }

    public void MathTestTest(View view) {
        Intent gintent = getIntent();
        final String test = gintent.getStringExtra(MainActivity.TEST_TYPE);
        Intent intent = new Intent(this, CountDown.class);
        String testorpractice = "Test";

        Bundle extras = new Bundle();
        extras.putString("TESTORPRACTICE", testorpractice);
        extras.putString("MATHORSEQ", test);
        intent.putExtras(extras);
        startActivity(intent);
        finish();
    }

}
