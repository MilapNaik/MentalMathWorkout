package com.milapnaik.tradermathtest;

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

        // Create all tables
        public static final String TABLE_EM5 = "EASY_MATH5";
        public static final String TABLE_EM10 = "EASY_MATH10";
        public static final String TABLE_EM20 = "EASY_MATH20";
        public static final String TABLE_EM80 = "EASY_MATH80";

        public static final String TABLE_MM5 = "MEDIUM_MATH5";
        public static final String TABLE_MM10 = "MEDIUM_MATH10";
        public static final String TABLE_MM20 = "MEDIUM_MATH20";
        public static final String TABLE_MM80 = "MEDIUM_MATH80";

        public static final String TABLE_HM5 = "HARD_MATH5";
        public static final String TABLE_HM10 = "HARD_MATH10";
        public static final String TABLE_HM20 = "HARD_MATH20";
        public static final String TABLE_HM80 = "HARD_MATH80";

        public static final String TABLE_ES5 = "EASY_SEQ5";
        public static final String TABLE_ES10 = "EASY_SEQ10";
        public static final String TABLE_ES20 = "EASY_SEQ20";
        public static final String TABLE_ES50 = "EASY_SEQ50";

        public static final String TABLE_MS5 = "MEDIUM_SEQ5";
        public static final String TABLE_MS10 = "MEDIUM_SEQ10";
        public static final String TABLE_MS20 = "MEDIUM_SEQ20";
        public static final String TABLE_MS50 = "MEDIUM_SEQ50";

        public static final String TABLE_HS5 = "HARD_SEQ5";
        public static final String TABLE_HS10 = "HARD_SEQ10";
        public static final String TABLE_HS20 = "HARD_SEQ20";
        public static final String TABLE_HS50 = "HARD_SEQ50";

    }
}