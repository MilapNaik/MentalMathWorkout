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
    public String CREATE_EMQUERY = "CREATE TABLE " + TableInfo.TABLE_EM + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MMQUERY = "CREATE TABLE " + TableInfo.TABLE_MM + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HMQUERY = "CREATE TABLE " + TableInfo.TABLE_HM + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

    public String CREATE_ESQUERY = "CREATE TABLE " + TableInfo.TABLE_ES + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MSQUERY = "CREATE TABLE " + TableInfo.TABLE_MS + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HSQUERY = "CREATE TABLE " + TableInfo.TABLE_HS + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

    // Delete everything but top 5 high scores
    public String DEL_ALLBUTES = "DELETE FROM " +
            TableInfo.TABLE_ES + " WHERE " +
            TableInfo.LB_RANK + " NOT IN (SELECT " +
            TableInfo.LB_RANK + " FROM " +
            TableInfo.TABLE_ES + " ORDER BY " +
            TableInfo.LB_SCORE + " DESC, " +
            TableInfo.LB_TIME + " ASC LIMIT 5);";

    public String DROP_QUERY = "DELETE DATABASE " + TableInfo.DATABASE_NAME + ";";


    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);

        //this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_EMQUERY);
        sdb.execSQL(CREATE_MMQUERY);
        sdb.execSQL(CREATE_HMQUERY);

        sdb.execSQL(CREATE_ESQUERY);
        sdb.execSQL(CREATE_MSQUERY);
        sdb.execSQL(CREATE_HSQUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HM);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_ES);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MS);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HS);
        onCreate(sdb);
    }

    public void addemLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_EM, null, cv);

        db.rawQuery(DEL_ALLBUTES, null);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addmmLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_MM, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addhmLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_HM, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }




    public void addesLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_ES, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addmsLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_MS, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addhsLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_HS, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }




    public  Cursor getemLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_EM, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor getmmLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_MM, null, null, null, null, null, TableInfo.LB_SCORE + " DESC", "5");
        return c;

    }
    public  Cursor gethmLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_HM, null, null, null, null, null, TableInfo.LB_SCORE + " DESC", "5");
        return c;

    }



    public  Cursor getesLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_ES, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor getmsLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_MS, null, null, null, null, null, TableInfo.LB_SCORE + " DESC", "5");
        return c;

    }
    public  Cursor gethsLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_HS, null, null, null, null, null, TableInfo.LB_SCORE + " DESC", "5");
        return c;

    }


}