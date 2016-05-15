package com.milapnaik.tradermathtest;

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

        if (method.equals("add_eminfo")){ //Add Easy Math information
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            int scoreint = Integer.parseInt(score);

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addemLeaderboard(ctx, db, rank, scoreint, time);
            return "High Score added";

        }
        else if (method.equals("add_mminfo")){ //Add Medium Math information
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            int scoreint = Integer.parseInt(score);

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addmmLeaderboard(ctx, db, rank, scoreint, time);
            return "High Score added";

        }
        else if (method.equals("add_hminfo")){ //Add Hard Math information
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            int scoreint = Integer.parseInt(score);

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addhmLeaderboard(ctx, db, rank, scoreint, time);
            return "High Score added";

        }
        else if (method.equals("add_esinfo")){ //Add Easy Sequence information
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            int scoreint = Integer.parseInt(score);

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addesLeaderboard(ctx, db, rank, scoreint, time);
            return "High Score added";

        }
        else if (method.equals("add_msinfo")){ //Add Medium Sequence information
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            int scoreint = Integer.parseInt(score);

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addmsLeaderboard(ctx, db, rank, scoreint, time);
            return "High Score added";

        }
        else if (method.equals("add_hsinfo")){ //Add Hard Sequence information
            String rank = params[1];
            String score = params[2];
            String time = params[3];

            int scoreint = Integer.parseInt(score);

            SQLiteDatabase db = dbops.getWritableDatabase();
            dbops.addhsLeaderboard(ctx, db, rank, scoreint, time);
            return "High Score added";

        }
        else if (method.equals("get_eminfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.getemLeaderboard(ctx, db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, time;
            int score;
            int row = 1;
            String rownumber = Integer.toString(row);

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getInt(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rownumber, score, time);
                row = Integer.parseInt(rownumber);
                row++;
                rownumber = Integer.toString(row);
                publishProgress(leaderboard);
            }
            db.close();
            return "get_info";
        }
        else if (method.equals("get_mminfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.getmmLeaderboard(ctx, db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, time;
            int score;
            int row = 1;
            String rownumber = Integer.toString(row);

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getInt(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rownumber, score, time);
                row = Integer.parseInt(rownumber);
                row++;
                rownumber = Integer.toString(row);
                publishProgress(leaderboard);
            }
            db.close();
            return "get_info";
        }
        else if (method.equals("get_hminfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.gethmLeaderboard(ctx, db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, time;
            int score;
            int row = 1;
            String rownumber = Integer.toString(row);

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getInt(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rownumber, score, time);
                row = Integer.parseInt(rownumber);
                row++;
                rownumber = Integer.toString(row);
                publishProgress(leaderboard);
            }
            db.close();
            return "get_info";
        }
        else if (method.equals("get_esinfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.getesLeaderboard(ctx, db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, time;
            int score;
            int row = 1;
            String rownumber = Integer.toString(row);

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getInt(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rownumber, score, time);
                row = Integer.parseInt(rownumber);
                row++;
                rownumber = Integer.toString(row);
                publishProgress(leaderboard);
            }
            db.close();
            return "get_info";
        }
        else if (method.equals("get_msinfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.getmsLeaderboard(ctx, db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, time;
            int score;
            int row = 1;
            String rownumber = Integer.toString(row);

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getInt(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rownumber, score, time);
                row = Integer.parseInt(rownumber);
                row++;
                rownumber = Integer.toString(row);
                publishProgress(leaderboard);
            }
            db.close();
            return "get_info";
        }
        else if (method.equals("get_hsinfo")){
            listView = (ListView) activity.findViewById(R.id.display_listview);

            SQLiteDatabase db = dbops.getReadableDatabase();
            Cursor Leaderboard = dbops.gethsLeaderboard(ctx, db);

            lbAdapter = new LB_Adapter(ctx, R.layout.display_leaderboard_row);

            String rank, time;
            int score;
            int row = 1;
            String rownumber = Integer.toString(row);

            while(Leaderboard.moveToNext()){
                rank = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_RANK));
                score = Leaderboard.getInt(Leaderboard.getColumnIndex(TableData.TableInfo.LB_SCORE));
                time = Leaderboard.getString(Leaderboard.getColumnIndex(TableData.TableInfo.LB_TIME));
                LB leaderboard = new LB(rownumber, score, time);
                row = Integer.parseInt(rownumber);
                row++;
                rownumber = Integer.toString(row);
                publishProgress(leaderboard);
            }
            db.close();
            return "get_info";
        }


        dbops.close();
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
