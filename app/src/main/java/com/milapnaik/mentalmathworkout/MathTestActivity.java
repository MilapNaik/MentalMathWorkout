package com.milapnaik.mentalmathworkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

/**
 * Created by MilapNaik on 3/18/16.
 */
public class MathTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
    }


}
