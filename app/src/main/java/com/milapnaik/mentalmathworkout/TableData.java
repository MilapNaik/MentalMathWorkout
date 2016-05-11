package com.milapnaik.mentalmathworkout;

import android.provider.BaseColumns;

/**
 * Created by MilapNaik on 4/26/16.
 */
public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns{

        public static final String LB_RANK = "LB_RANK";
        public static final String LB_SCORE = "LB_SCORE";
        public static final String LB_TIME = "LB_TIME";

        public static final String DATABASE_NAME = "HIGH_SCORES";
        public static final String TABLE_NAME = "EASY_MATH";
        public static final String TABLE_NAME2 = "MEDIUM_MATH";
        public static final String TABLE_NAME3 = "HARD_MATH";

    }
}