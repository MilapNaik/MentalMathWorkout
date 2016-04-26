package com.milapnaik.mentalmathworkout;

import android.provider.BaseColumns;

/**
 * Created by MilapNaik on 4/26/16.
 */
public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns{

        public final String PROBLEM = "PROBLEM";
        public final String ANSWER = "ANSWER";
        public static final String DATABASE_NAME = "PROBLEM_SETS";
        public static final String TABLE_NAME = "TRADER_PROBLEM_SET";

    }
}
