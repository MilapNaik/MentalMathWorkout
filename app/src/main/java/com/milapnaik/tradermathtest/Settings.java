package com.milapnaik.tradermathtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
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

        // Check what difficulty was previously pressed
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");

        // Re-press that button
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

    // When a new radio button is pressed
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

        // Toast which difficulty was pressed
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Difficulty = sharedpreferences.getString("PREF_DIFFICULTY", "Easy");

        Toast.makeText(Settings.this,
                "Difficulty: " + Difficulty,
                Toast.LENGTH_SHORT).show();
    }

    // When 5 question amount is pressed, set preferences to new amount and toast
    public void set5questions(View view) {
        SharedPreferences preference = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putInt("NUM_QUESTIONS", 5);
        editor.commit();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final int n = sharedpreferences.getInt("NUM_QUESTIONS", 5);

        Toast.makeText(Settings.this,
                "Set to " + n + " questions",
                Toast.LENGTH_SHORT).show();;
    }

    public void set10questions(View view) {
        SharedPreferences preference = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putInt("NUM_QUESTIONS", 10);
        editor.commit();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final int n = sharedpreferences.getInt("NUM_QUESTIONS", 5);

        Toast.makeText(Settings.this,
                "Set to " + n + " questions",
                Toast.LENGTH_SHORT).show();
    }

    public void set20questions(View view) {
        SharedPreferences preference = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putInt("NUM_QUESTIONS", 20);
        editor.commit();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final int n = sharedpreferences.getInt("NUM_QUESTIONS", 5);

        Toast.makeText(Settings.this,
                "Set to " + n + " questions",
                Toast.LENGTH_SHORT).show();
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
