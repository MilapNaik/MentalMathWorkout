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
        public static final String TABLE_EM = "EASY_MATH";
        public static final String TABLE_MM = "MEDIUM_MATH";
        public static final String TABLE_HM = "HARD_MATH";

        public static final String TABLE_ES = "EASY_SEQ";
        public static final String TABLE_MS = "MEDIUM_SEQ";
        public static final String TABLE_HS = "HARD_SEQ";

    }
}