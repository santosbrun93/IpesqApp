package com.fadergs.projeto.ipesq;

import android.provider.BaseColumns;

public class MyTableData {

    MyTableData() {
        // Empty Constructor...
    }

    static abstract class DETAILS implements BaseColumns {

        static final String TABLE_NAME = "TABLENAME";
        static final String ID = "ID";
        static final String USERNAME = "USERNAME";
        static final String EMAILID = "EMAILID";
        static final String PASSWORD = "PASSWORD";
        static final String COD_NIVEL = "COD_NIVEL";

        static final String CREATE_STATEMENT = " CREATE TABLE "
                + TABLE_NAME + " ( "
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT, "
                + EMAILID + " TEXT, "
                + PASSWORD + " TEXT, "
                + COD_NIVEL + " INTEGER" + ");";

        static final String DELETE_STATEMENT = "DROP TABLE " + TABLE_NAME;

    }
}