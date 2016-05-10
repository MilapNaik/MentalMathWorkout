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
            + TableInfo.QUESTION_ID + " TEXT," + TableInfo.QUESTION + " TEXT,"+ TableInfo.ANSWER +
            " TEXT );";


    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);

        //Insert problems for problem set

        /*DatabaseOperations db = new DatabaseOperations(ctx);
        insertProblem(db,"1", "9+9", "18");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void insertProblem(DatabaseOperations dop,String id, String problem, String answer){

        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TableInfo.QUESTION_ID, id);
        cv.put(TableInfo.QUESTION, problem);
        cv.put(TableInfo.ANSWER, answer);

        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        //Log.d("Database Operations", "One row inserted");
    }

    public Cursor getProblem(DatabaseOperations dop){

        SQLiteDatabase SQ = dop.getWritableDatabase();
        String[] columns = {TableInfo.QUESTION_ID, TableInfo.QUESTION, TableInfo.ANSWER};

        Cursor c = SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return c;

    }
}