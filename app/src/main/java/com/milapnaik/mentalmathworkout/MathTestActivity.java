package com.milapnaik.mentalmathworkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import android.widget.Button;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by MilapNaik on 3/18/16.
 */
public class MathTestActivity extends AppCompatActivity {

    int i = 0;
    int correctcount = 0;
    int n = 20; /*How many rows this test*/
    String[] mathTest = new String[40];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathtest);

        final TextView mathProblem = (TextView) findViewById(R.id.mathProblem);
        final EditText mathAnswer = (EditText) findViewById(R.id.mathAnswer);

        //Styling for the question text
        mathProblem.setTextSize(30);
        mathProblem.setTextColor(Color.rgb(0, 0, 0));


        //Try to read the problem and answers text file
        try {
            InputStream is = this.getResources().openRawResource(R.raw.mediummath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            int n = 20; /*How many rows this test has*/
            /*read in file to array*/
            for (i = 0; i < n; i=i+2) {
                if ((line = reader.readLine()) != null)
                    mathTest[i] = line; //Enter in problem
                if ((line = reader.readLine()) != null)
                    mathTest[i+1] = line; //Enter in solution
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        i = 0;

        mathProblem.setText(mathTest[0]);

        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick(View view) {


                    String answer = mathAnswer.toString() ;
                    String correctAnswer = mathTest[i+1];


                        if (answer.equals(correctAnswer)){
                            correctcount++;
                            Toast.makeText(MathTestActivity.this,
                                            correctcount,
                                            Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(MathTestActivity.this,
                                            correctAnswer,
                                            Toast.LENGTH_SHORT).show();

                        }
                        i = i + 2;
                        mathProblem.setText(mathTest[i]);
            }
        });
    }
}
