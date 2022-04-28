package com.example.bankconnect;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.my.cv.builder.entity.Experience;

import java.util.ArrayList;

public class TransactionDbHelper extends DbHelper {

    public static final String _TABLE = "experience_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_1 = "company";
    public static final String COLUMN_2 = "description";
    public static final String COLUMN_3 = "date_start";
    public static final String COLUMN_4 = "date_end";
    public static final String COLUMN_5 = "summary";
    public static final String COLUMN_6 = "id_model";

    public ExperienceDbHelper(@Nullable Context context) {
        super(context);
    }

    public boolean add(Experience item){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        cv.put(COLUMN_1,item.getCompany());
        cv.put(COLUMN_2,item.getDescription());
        cv.put(COLUMN_3,item.getDateStart());
        cv.put(COLUMN_4,item.getDateEnd());
        cv.put(COLUMN_5,item.getSummary());
        cv.put(COLUMN_6,item.getIdModel());

        long rs= db.insert(_TABLE,null,cv);
        db.close();
        if(rs == -1){
            return  false;
        }else {
            return true;
        }
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

    public boolean deleteModelItem(String idModel){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        long rs= db.delete(_TABLE, COLUMN_6+"=?", new String[]{idModel});
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

    public boolean edit(Experience item){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        cv.put(COLUMN_1,item.getCompany());
        cv.put(COLUMN_2,item.getDescription());
        cv.put(COLUMN_3,item.getDateStart());
        cv.put(COLUMN_4,item.getDateEnd());
        cv.put(COLUMN_5,item.getSummary());
        //cv.put(COLUMN_6,item.getIdModel());

        long rs= db.update(_TABLE,cv, COLUMN_ID+"=?", new String[]{item.getId().toString()});
        db.close();
        if(rs == -1){
            return  false;
        }else {
            return true;
        }
    }

    @SuppressLint("Range")
    public Experience findById(Integer id){

        Experience item= null;

        String query="SELECT * FROM " + _TABLE + " WHERE " + COLUMN_ID + "=" + id;
        SQLiteDatabase db= this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                item = new Experience(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_1)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_2)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_3)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_4)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_5)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_6)));

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return  item;
    }


    @SuppressLint("Range")
    public Integer count(Integer idModel){

        Integer item= 0;

        String query="SELECT count(*) as nbr FROM " + _TABLE + " WHERE " + COLUMN_6 + "=" + idModel;
        SQLiteDatabase db= this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                item= cursor.getInt(0);

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return  item;
    }


    @SuppressLint("Range")
    public ArrayList<Experience> getAll(Integer idModel){

        ArrayList<Experience> items= new ArrayList<Experience>();

        String query="SELECT * FROM " + _TABLE + " WHERE " + COLUMN_6 + "=" + idModel;
        SQLiteDatabase db= this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                 Experience item = new Experience(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_1)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_2)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_3)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_4)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_5)),
                         cursor.getInt(cursor.getColumnIndex(COLUMN_6)));


                items.add(item);

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

         return  items;
    }


}
