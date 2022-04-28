package com.example.bankconnect;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionDbHelper extends DbHelper {

    public static final String _TABLE = "transaction_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_1 = "icon";
    public static final String COLUMN_2 = "label";
    public static final String COLUMN_3 = "price";
    public static final String COLUMN_4 = "date";
    public static final String COLUMN_5 = "num_compte";
    public static final String COLUMN_6 = "num_ref";
    public static final String COLUMN_7 = "sold";


    public TransactionDbHelper(@Nullable Context context) {
        super(context);
    }

    public boolean add(Transaction item){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        cv.put(COLUMN_1,item.getIcon());
        cv.put(COLUMN_2,item.getLabel());
        cv.put(COLUMN_3,item.getPrice());
        cv.put(COLUMN_4,item.getDate());
        cv.put(COLUMN_5,item.getNumCompte());
        cv.put(COLUMN_6,item.getNumRef());
        cv.put(COLUMN_7,item.getSold());

        long rs= db.insert(_TABLE,null,cv);
        db.close();
        if(rs == -1){
            return  false;
        }else {
            return true;
        }
    }


    @SuppressLint("Range")
    public Transaction findById(Integer id){

        Transaction item= null;

        String query="SELECT * FROM " + _TABLE + " WHERE " + COLUMN_ID + "=" + id;
        SQLiteDatabase db= this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                item = new Transaction(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_1)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_2)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_3)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_4)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_5)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_6)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_7))
                );

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return  item;
    }


    public boolean deleteItem(String id){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        long rs= db.delete(_TABLE, COLUMN_ID+"=?", new String[]{id});
        db.close();
        if(rs == -1){
            return  false;
        }else {
            return true;
        }
    }


    public boolean deleteAll(){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        long rs= db.delete(_TABLE, "", new String[]{});
        db.close();
        if(rs == -1){
            return  false;
        }else {
            return true;
        }
    }


    @SuppressLint("Range")
    public ArrayList<Transaction> getAll(){

        ArrayList<Transaction> items= new ArrayList<Transaction>();

        String query="SELECT * FROM " + _TABLE ;
        SQLiteDatabase db= this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                 Transaction item = new Transaction(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_1)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_2)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_3)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_4)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_5)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_6)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_7))
                         );


                items.add(item);

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

         return  items;
    }


}
