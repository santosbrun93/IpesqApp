package com.fadergs.projeto.ipesq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DATABASE_SOURCE {

    Context context;
    MyCoreDataBase myCoreDataBase;
    SQLiteDatabase db;
    ContentValues Values;

    DATABASE_SOURCE(Context context) {
        this.context = context;
        myCoreDataBase = new MyCoreDataBase(context);
        db = myCoreDataBase.getWritableDatabase();
    }

    void openDB() {
        db = myCoreDataBase.getWritableDatabase();
    }

    public void closeDB() {
        db.close();
    }

    void InsertAccountDetails(String Username, String Emailid, String Password, int cod_nivel) {
        Values = new ContentValues();
        Values.put(MyTableData.DETAILS.USERNAME, Username);
        Values.put(MyTableData.DETAILS.EMAILID, Emailid);
        Values.put(MyTableData.DETAILS.PASSWORD, Password);
        Values.put(MyTableData.DETAILS.COD_NIVEL, cod_nivel);

        db.insert(MyTableData.DETAILS.TABLE_NAME, null, Values);

        Toast.makeText(context, "SignUp Done Successfully",
                Toast.LENGTH_SHORT).show();
    }

    Cursor SOURCELOGIN_METHOD() {
        db = myCoreDataBase.getWritableDatabase();
        Cursor cursor = db.query(MyTableData.DETAILS.TABLE_NAME, null,
                null, null, null, null, null, null);
        return cursor;
    }

}
