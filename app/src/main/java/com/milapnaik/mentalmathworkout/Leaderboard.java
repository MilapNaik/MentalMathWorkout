package com.milapnaik.mentalmathworkout;

import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
import android.text.Html;

import android.database.Cursor;
import android.content.Context;


/**
 * Created by MilapNaik on 5/5/16.
 */
public class Leaderboard extends AppCompatActivity {

    private Cursor Questions;
    private DatabaseOperations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        EditText id;
        TextView showq;
        String idnumber;
        Context ctx = this;

        /*id = (EditText) findViewById(R.id.editText);
        showq = (TextView) findViewById(R.id.textView);

        idnumber = id.getText().toString();

        db = new DatabaseOperations(ctx);
        db.insertProblem(db, "1", "9+9", "18");
        Questions = db.getProblem(db);
        db.insertProblem(db, "1", "9+9", "18");
        Questions.moveToFirst();
        boolean status = false;
        String Qn = "";
        showq.setText(Questions.getString(1));
        do{
            if (id.equals(Questions.getString(0))){
                showq.setText(Questions.getString(1));
            }

        }while(Questions.moveToNext());*/

    }
}