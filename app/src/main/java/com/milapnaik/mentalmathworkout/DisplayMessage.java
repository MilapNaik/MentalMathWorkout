package com.milapnaik.mentalmathworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by MilapNaik on 3/14/16.
 */


public class DisplayMessage extends AppCompatActivity {
        public String message = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        Intent intent = getIntent();

        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);

    }
}

