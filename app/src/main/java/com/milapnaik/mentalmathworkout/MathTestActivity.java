package com.milapnaik.mentalmathworkout;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import java.io.File;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

/**
 * Created by MilapNaik on 3/18/16.
 */
public class MathTestActivity extends AppCompatActivity {

    private Context ctx;

    public MathTestActivity(Context context) {
        this.ctx = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        TextView mathProblem = (TextView) findViewById(R.id.mathProblem);
        final EditText mathAnswer = (EditText) findViewById(R.id.mathAnswer);

        mathProblem.setTextSize(40);
        mathProblem.setTextColor(Color.rgb(0, 0, 0));
        //String Problem1 = "29153 + 9";
        //final int correctAnswer1 = 29153 + 9;
        //mathProblem.setText(Problem1);

        File file = new File("raw/mediummath.txt");
        String readFile = "raw/mediummath.txt";
        AssetManager am = ctx.getAssets();
        try {
            InputStream is = am.open(readFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                    mathProblem.setText(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return mLines;



        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    int correctcount = 0;
                    int answer = Integer.parseInt(mathAnswer.getText().toString());
                    /*if (answer == correctAnswer1){
                        Toast.makeText(MathTestActivity.this,
                                        R.string.correct_toast,
                                        Toast.LENGTH_SHORT).show();

                        correctcount++;
                    }
                    else{
                        Toast.makeText(MathTestActivity.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }*/
            }
        });




        RelativeLayout layout = (RelativeLayout) findViewById(R.id.mtestcontent);

    }
}
