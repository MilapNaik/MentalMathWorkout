package com.milapnaik.mentalmathworkout;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by MilapNaik on 5/10/16.
 */
public class BackgroundTask extends AsyncTask<String,Void,String>{
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        DatabaseOperations dbops = new DatabaseOperations(ctx);

        if (method.equals("add_info")){
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addLeaderboard(db, rank, score, time);
            return "High Score added";

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
    }
}
