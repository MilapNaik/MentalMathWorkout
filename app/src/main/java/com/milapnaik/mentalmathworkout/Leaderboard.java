package com.milapnaik.mentalmathworkout;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
import android.text.Html;
import android.widget.ListView;

import android.database.Cursor;
import android.content.Context;


/**
 * Created by MilapNaik on 5/5/16.
 */
public class Leaderboard extends AppCompatActivity {

    private DatabaseOperations DBop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        EditText id;
        TextView showq;
        String idnumber;
        Context ctx = this;


        BackgroundTask backgroundTask = new BackgroundTask(ctx);
        backgroundTask.execute("get_eminfo");


        /*final ListView listview = (ListView) findViewById(R.id.display_listview);
        String[] values = new String[] {TableData.TableInfo.LB_RANK, TableData.TableInfo.LB_SCORE,
                                        TableData.TableInfo.LB_TIME};
        int[] toViewIDS = new int[] {R.id.lb_rank, R.id.lb_score, R.id.lb_time};

        DBop = new DatabaseOperations(ctx);
        id = (EditText) findViewById(R.id.editText);
        showq = (TextView) findViewById(R.id.textView);

        idnumber = id.getText().toString();


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