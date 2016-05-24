package com.milapnaik.tradermathtest;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import com.milapnaik.tradermathtest.TableData.TableInfo;

/**
 * Created by MilapNaik on 4/26/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    private Context ctx;
    int Questions;
    Boolean isTest = false;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final int database_version = 1;

    // Create Easy Math tables for 5 questions, 10 questions, 20 questions, and 80 questions
    public String CREATE_EMQUERY5 = "CREATE TABLE " + TableInfo.TABLE_EM5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_EMQUERY10 = "CREATE TABLE " + TableInfo.TABLE_EM10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_EMQUERY20 = "CREATE TABLE " + TableInfo.TABLE_EM20 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_EMQUERY80 = "CREATE TABLE " + TableInfo.TABLE_EM80 + "("
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
    public String CREATE_MMQUERY80 = "CREATE TABLE " + TableInfo.TABLE_MM80 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

    public String CREATE_HMQUERY5 = "CREATE TABLE " + TableInfo.TABLE_HM5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HMQUERY10 = "CREATE TABLE " + TableInfo.TABLE_HM10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HMQUERY20 = "CREATE TABLE " + TableInfo.TABLE_HM20 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HMQUERY80 = "CREATE TABLE " + TableInfo.TABLE_HM80 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

    // Create Easy Sequence tables for 5 questions, 10 questions, 20 questions, and 50 questions
    public String CREATE_ESQUERY5 = "CREATE TABLE " + TableInfo.TABLE_ES5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_ESQUERY10 = "CREATE TABLE " + TableInfo.TABLE_ES10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_ESQUERY20 = "CREATE TABLE " + TableInfo.TABLE_ES20 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_ESQUERY50 = "CREATE TABLE " + TableInfo.TABLE_ES50 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";


    public String CREATE_MSQUERY5 = "CREATE TABLE " + TableInfo.TABLE_MS5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MSQUERY10 = "CREATE TABLE " + TableInfo.TABLE_MS10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MSQUERY20 = "CREATE TABLE " + TableInfo.TABLE_MS20 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_MSQUERY50 = "CREATE TABLE " + TableInfo.TABLE_MS50 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

    public String CREATE_HSQUERY5 = "CREATE TABLE " + TableInfo.TABLE_HS5 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HSQUERY10 = "CREATE TABLE " + TableInfo.TABLE_HS10 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HSQUERY20 = "CREATE TABLE " + TableInfo.TABLE_HS20 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";
    public String CREATE_HSQUERY50 = "CREATE TABLE " + TableInfo.TABLE_HS50 + "("
            + TableInfo.LB_RANK + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ," + TableInfo.LB_SCORE +
            " INT,"+ TableInfo.LB_TIME + " VARCHAR );";

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
        sdb.execSQL(CREATE_EMQUERY80);

        sdb.execSQL(CREATE_MMQUERY5);
        sdb.execSQL(CREATE_MMQUERY10);
        sdb.execSQL(CREATE_MMQUERY20);
        sdb.execSQL(CREATE_MMQUERY80);

        sdb.execSQL(CREATE_HMQUERY5);
        sdb.execSQL(CREATE_HMQUERY10);
        sdb.execSQL(CREATE_HMQUERY20);
        sdb.execSQL(CREATE_HMQUERY80);

        sdb.execSQL(CREATE_ESQUERY5);
        sdb.execSQL(CREATE_ESQUERY10);
        sdb.execSQL(CREATE_ESQUERY20);
        sdb.execSQL(CREATE_ESQUERY50);

        sdb.execSQL(CREATE_MSQUERY5);
        sdb.execSQL(CREATE_MSQUERY10);
        sdb.execSQL(CREATE_MSQUERY20);
        sdb.execSQL(CREATE_MSQUERY50);

        sdb.execSQL(CREATE_HSQUERY5);
        sdb.execSQL(CREATE_HSQUERY10);
        sdb.execSQL(CREATE_HSQUERY20);
        sdb.execSQL(CREATE_HSQUERY50);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2){
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM20);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_EM80);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM20);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MM80);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HM5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HM10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HM20);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HM80);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_ES5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_ES10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_ES20);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_ES50);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MS5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MS10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MS20);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_MS50);

        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HS5);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HS10);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HS20);
        sdb.execSQL("DROP TABLE IF EXISTS " + TableInfo.TABLE_HS50);

        onCreate(sdb);
    }

    // When called, will add a score to a leaderboard for Easy Math database for 5, 10, 20, or 80 questions
    public void addemLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;


        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            db.insert(TableInfo.TABLE_EM80, null, cv);
        else if (Questions == 20)
            db.insert(TableInfo.TABLE_EM20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_EM10, null, cv);
        else
            db.insert(TableInfo.TABLE_EM5, null, cv);

    }
    public void addmmLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;

        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            db.insert(TableInfo.TABLE_MM80, null, cv);
        else if (Questions == 20)
            db.insert(TableInfo.TABLE_MM20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_MM10, null, cv);
        else
            db.insert(TableInfo.TABLE_MM5, null, cv);

    }
    public void addhmLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;

        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            db.insert(TableInfo.TABLE_HM80, null, cv);
        else if (Questions == 20)
            db.insert(TableInfo.TABLE_HM20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_HM10, null, cv);
        else
            db.insert(TableInfo.TABLE_HM5, null, cv);
    }



    // When called, will add a score to a leaderboard for Easy Sequence database for 5, 10, 20, or 80 questions
    public void addesLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;

        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            db.insert(TableInfo.TABLE_ES50, null, cv);
        else if (Questions == 20)
            db.insert(TableInfo.TABLE_ES20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_ES10, null, cv);
        else
            db.insert(TableInfo.TABLE_ES5, null, cv);
    }
    public void addmsLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;

        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            db.insert(TableInfo.TABLE_MS50, null, cv);
        else if (Questions == 20)
            db.insert(TableInfo.TABLE_MS20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_MS10, null, cv);
        else
            db.insert(TableInfo.TABLE_MS5, null, cv);
    }
    public void addhsLeaderboard(Context context, SQLiteDatabase db,String rank, int score, String time){

        ContentValues cv = new ContentValues();

        cv.put(TableInfo.LB_SCORE, score);
        cv.put(TableInfo.LB_TIME, time);
        this.ctx = context;

        // Find how manny questions from the preferences
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            db.insert(TableInfo.TABLE_HS50, null, cv);
        else if (Questions == 20)
            db.insert(TableInfo.TABLE_HS20, null, cv);
        else if (Questions == 10)
            db.insert(TableInfo.TABLE_HS10, null, cv);
        else
            db.insert(TableInfo.TABLE_HS5, null, cv);
    }




    public  Cursor getemLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        Cursor c = db.query(TableInfo.TABLE_EM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            c = db.query(TableInfo.TABLE_EM80, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 20)
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

        Cursor c = db.query(TableInfo.TABLE_MM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            c = db.query(TableInfo.TABLE_MM80, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 20)
            c = db.query(TableInfo.TABLE_MM20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_MM10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_MM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor gethmLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        Cursor c = db.query(TableInfo.TABLE_HM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            c = db.query(TableInfo.TABLE_HM80, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 20)
            c = db.query(TableInfo.TABLE_HM20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_HM10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_HM5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }



    public  Cursor getesLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        Cursor c = db.query(TableInfo.TABLE_ES5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            c = db.query(TableInfo.TABLE_ES50, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 20)
            c = db.query(TableInfo.TABLE_ES20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_ES10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_ES5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor getmsLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        Cursor c = db.query(TableInfo.TABLE_MS5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            c = db.query(TableInfo.TABLE_MS50, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 20)
            c = db.query(TableInfo.TABLE_MS20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_MS10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_MS5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }
    public  Cursor gethsLeaderboard(Context context, SQLiteDatabase db){

        String[] columns = {TableInfo.LB_RANK, TableInfo.LB_SCORE, TableInfo.LB_TIME};
        this.ctx = context;

        Cursor c = db.query(TableInfo.TABLE_HS5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        sharedpreferences = ctx.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Questions = sharedpreferences.getInt("NUM_QUESTIONS", 5);
        isTest = sharedpreferences.getBoolean("Test", false);

        if (isTest)
            c = db.query(TableInfo.TABLE_HS50, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 20)
            c = db.query(TableInfo.TABLE_HS20, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else if (Questions == 10)
            c = db.query(TableInfo.TABLE_HS10, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        else
            c = db.query(TableInfo.TABLE_HS5, null, null, null, null, null, TableInfo.LB_SCORE + " DESC, " + TableInfo.LB_TIME + " ASC", "5");
        return c;

    }

    // Optional method I decided not to use. Would delete all records for a given
    // table except the top 5 scores. Possible to use after addesLeaderboard method
    // or similar methods after adding a score.
    public void DeletePast5 (SQLiteDatabase db, String table){
        // Not currently in use, DeletePast5(db, TableInfo.TABLE_EM5); when needed

        // Delete everything but top 5 high scores
        String DEL_ROWS = "DELETE FROM " +
                table + " WHERE " +
                TableInfo.LB_RANK + " NOT IN (SELECT " +
                TableInfo.LB_RANK + " FROM " +
                table + " ORDER BY " +
                TableInfo.LB_SCORE + " DESC, " +
                TableInfo.LB_TIME + " ASC LIMIT 5);";

        db.execSQL(DEL_ROWS);

    }


}