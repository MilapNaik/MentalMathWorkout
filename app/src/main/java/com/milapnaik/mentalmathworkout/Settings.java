package com.milapnaik.mentalmathworkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.SharedPreferences.Editor;

/**
 * Created by MilapNaik on 5/7/16.
 */
public class Settings extends AppCompatActivity {
    RadioGroup difficulty;
    RadioButton easy, medium, hard;
    TextView settings;
    Button q5, q10, q20;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String Difficulty;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        difficulty = (RadioGroup) findViewById(R.id.difficulty);

        easy = (RadioButton) findViewById(R.id.easy);
        medium = (RadioButton) findViewById(R.id.medium);
        hard = (RadioButton) findViewById(R.id.hard);

        q5 = (Button) findViewById(R.id.q5);
        q10 = (Button) findViewById(R.id.q10);
        q20 = (Button) findViewById(R.id.q20);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");

        if( Difficulty.equals("Hard")) {
            hard.setChecked(true);
            medium.setChecked(false);
            easy.setChecked(false);
        }
        else if( Difficulty.equals("Medium")) {
            medium.setChecked(true);
            hard.setChecked(false);
            easy.setChecked(false);
        }
        else {
            easy.setChecked(true);
            medium.setChecked(false);
            hard.setChecked(false);
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        SharedPreferences preference = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        Editor editor = preference.edit();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.easy:
                if (checked) {
                    // Easy difficulty
                    editor.putString("PREF_DIFFICULTY", "Easy");
                    editor.commit();
                    break;
                }
            case R.id.medium:
                if (checked) {
                    // Medium difficulty
                    editor.putString("PREF_DIFFICULTY", "Medium");
                    editor.commit();
                    break;
                }
            case R.id.hard:
                if (checked) {
                    // Hard difficulty
                    editor.putString("PREF_DIFFICULTY", "Hard");
                    editor.commit();
                    break;
                }
        }
    }
}
