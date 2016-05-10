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
            + TableInfo.LB_RANK + " TEXT," + TableInfo.LB_SCORE + " TEXT,"+ TableInfo.LB_TIME +
            " TEXT );";


    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void addLeaderboard(SQLiteDatabase db,String rank, String score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_RANK, rank);
        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_NAME, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }

    public  Cursor getLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return c;

    }
}