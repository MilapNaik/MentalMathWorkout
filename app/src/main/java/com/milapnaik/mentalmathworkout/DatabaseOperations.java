package com.milapnaik.mentalmathworkout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.milapnaik.mentalmathworkout.TableData.TableInfo;

/**
 * Created by MilapNaik on 4/26/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableInfo.TABLE_NAME + "("
                                  + TableInfo.PROBLEM + " TEXT," + TableInfo.ANSWER +
                                  "TEXT );";


    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}
