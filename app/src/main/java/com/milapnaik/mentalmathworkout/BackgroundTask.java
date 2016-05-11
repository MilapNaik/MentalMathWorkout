package com.milapnaik.mentalmathworkout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

/**
 * Created by MilapNaik on 5/10/16.
 */
public class BackgroundTask extends AsyncTask<String, LB,String>{
    Context ctx;
    LB_Adapter lbAdapter;
    Activity activity;
    ListView listView;

    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        DatabaseOperations dbops = new DatabaseOperations(ctx);

        if (method.equals("add_eminfo")){
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addemLeaderboard(db, rank, score, time);
            return "High Score added";

        }
        else if (method.equals("add_mminfo")){
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addmmLeaderboard(db, rank, score, time);
            return "High Score added";

        }
        else if (method.equals("add_hminfo")){
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addhmLeaderboard(db, rank, score, time);
            return "High Score added";

        }
        else if (method.equals("get_eminfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.getemLeaderboard(db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, score, time;

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rank, score, time);
                publishProgress(leaderboard);
            }
                return "get_info";
        }
        else if (method.equals("get_mminfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.getmmLeaderboard(db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, score, time;

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rank, score, time);
                publishProgress(leaderboard);
            }
            return "get_info";
        }
        else if (method.equals("get_hminfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.gethmLeaderboard(db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, score, time;

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rank, score, time);
                publishProgress(leaderboard);
            }
            return "get_info";
        }



        return null;
    }

    @Override
    protected void onProgressUpdate(LB... values) {
        lbAdapter.add(values[0]);


    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_info")){
            listView.setAdapter(lbAdapter);
        }
        else{
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
    }
}
