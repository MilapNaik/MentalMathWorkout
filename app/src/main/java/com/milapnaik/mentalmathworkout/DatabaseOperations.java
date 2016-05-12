package com.milapnaik.mentalmathworkout;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;

import com.milapnaik.mentalmathworkout.TableData.TableInfo;

/**
 * Created by MilapNaik on 4/26/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    private Context ctx;
    int Questions;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final int database_version = 1;

    public String CREATE_EMQUERY5 = "CREATE TABLE " + TableInfo.TABLE_EM5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_EMQUERY10 = "CREATE TABLE " + TableInfo.TABLE_EM10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_EMQUERY20 = "CREATE TABLE " + TableInfo.TABLE_EM20 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

    public String CREATE_MMQUERY5 = "CREATE TABLE " + TableInfo.TABLE_MM5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MMQUERY10 = "CREATE TABLE " + TableInfo.TABLE_MM10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MMQUERY20 = "CREATE TABLE " + TableInfo.TABLE_MM20 + "("
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
            TableInfo.TABLE_HM + " WHERE " +
            TableInfo.LB_RANK + " NOT IN (SELECT " +
            TableInfo.LB_RANK + " FROM " +
            TableInfo.TABLE_HM + " ORDER BY " +
            TableInfo.LB_SCORE + " DESC, " +
            TableInfo.LB_TIME + " ASC LIMIT 5);";

    public String DROP_QUERY = "DELETE DATABASE " + TableInfo.DATABASE_NAME + ";";


    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);

        //this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_EMQUERY5);
        sdb.execSQL(CREATE_EMQUERY10);
        sdb.execSQL(CREATE_EMQUERY20);

        sdb.execSQL(CREATE_MMQUERY5);
        sdb.execSQL(CREATE_MMQUERY10);
        sdb.execSQL(CREATE_MMQUERY20);

        sdb.execSQL(CREATE_HMQUERY);

        sdb.execSQL(CREATE_ESQUERY);
        sdb.execSQL(CREATE_MSQUERY);
        sdb.execSQL(CREATE_HSQUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM20);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM20);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HM);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_ES);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MS);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HS);
        onCreate(sdb);
    }

    public void addemLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;


        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);

        if (Questions == 20)
            db.insert(TableInfo.TABLE_EM20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_EM10, null, cv);
        else
            db.insert(TableInfo.TABLE_EM5, null, cv);

        //Log.d("Database Operations", "One row inserted");
    }
    public void addmmLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;

        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);

        if (Questions == 20)
            db.insert(TableInfo.TABLE_MM20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_MM10, null, cv);
        else
            db.insert(TableInfo.TABLE_MM5, null, cv);

        db.rawQuery(DEL_ALLBUTES, null);
        //Log.d("Database Operations", "One row inserted");
    }
    public void addhmLeaderboard(SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);

        db.insert(TableInfo.TABLE_HM, null, cv);

        db.execSQL(DEL_ALLBUTES, null);
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




    public  Cursor getemLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        Cursor c = db.query(TableInfo.TABLE_EM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");;

        if (Questions == 20)
            c = db.query(TableInfo.TABLE_EM20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_EM10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_EM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");

        return c;

    }
    public  Cursor getmmLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        Cursor c = db.query(TableInfo.TABLE_EM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");;

        if (Questions == 20)
            c = db.query(TableInfo.TABLE_MM20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_MM10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_MM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor gethmLeaderboard(SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};

        Cursor c = db.query(TableInfo.TABLE_HM, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
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