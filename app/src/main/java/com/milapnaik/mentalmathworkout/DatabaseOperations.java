package com.milapnaik.mentalmathworkout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;

import com.milapnaik.mentalmathworkout.TableData.TableInfo;

/**
 * Created by MilapNaik on 4/26/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    Context ctx;
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableInfo.TABLE_NAME + "("
            + TableInfo.LB_RANK + " INT, " + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_QUERY2 = "CREATE TABLE " + TableInfo.TABLE_NAME2 + "("
            + TableInfo.LB_RANK + " INT, " + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_QUERY3 = "CREATE TABLE " + TableInfo.TABLE_NAME3 + "("
            + TableInfo.LB_RANK + " INT, " + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String DROP_QUERY = "DELETE DATABASE " + TableInfo.DATABASE_NAME + ";";


    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);

        //this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        sdb.execSQL(CREATE_QUERY2);
        sdb.execSQL(CREATE_QUERY3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){
        ctx.deleteDatabase(TableInfo.DATABASE_NAME);
        sdb.execSQL(CREATE_QUERY);
        sdb.execSQL(CREATE_QUERY2);
        sdb.execSQL(CREATE_QUERY3);

    }

    public void addemLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_NAME, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addmmLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_NAME2, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addhmLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_NAME3, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }

    public  Cursor getemLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_NAME, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor getmmLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_NAME2, null, null, null, null, null, TableInfo.LB_SCORE + " DESC", "5");
        return c;

    }
    public  Cursor gethmLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_NAME3, null, null, null, null, null, TableInfo.LB_SCORE + " DESC", "5");
        return c;

    }
}