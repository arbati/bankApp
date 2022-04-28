package com.example.bankconnect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "database2.db";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String certificationStatement = "CREATE TABLE " + TransactionDbHelper._TABLE + " (" + TransactionDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + TransactionDbHelper.COLUMN_1 + " TEXT," + TransactionDbHelper.COLUMN_2 + " TEXT, " + TransactionDbHelper.COLUMN_3 + " TEXT, " + TransactionDbHelper.COLUMN_4 + " TEXT, " + TransactionDbHelper.COLUMN_5 + " TEXT, " + TransactionDbHelper.COLUMN_6 + " TEXT, " + TransactionDbHelper.COLUMN_7 + " TEXT )";
        db.execSQL(certificationStatement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String userStatement = "DROP TABLE IF EXISTS " + TransactionDbHelper._TABLE;
        db.execSQL(userStatement);

    }

}
