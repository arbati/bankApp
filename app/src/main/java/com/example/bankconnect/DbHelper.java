package com.example.bankconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TRANSACTION_TABLE = "transaction_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ICON = "icon";
    public static final String COLUMN_LABEL = "label";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_COMPTE = "num_compte";
    public static final String COLUMN_REF = "num_ref";
    public static final String COLUMN_SOLDE = "solde";




    public DbHelper(@Nullable Context context) {
        super(context, "database_transaction.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String userStatement = "CREATE TABLE " + TRANSACTION_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_ICON + " TEXT," + COLUMN_LABEL + " TEXT, " + COLUMN_DATE + " DATE, " + COLUMN_COMPTE + " TEXT, " + COLUMN_REF + " TEXT, " + COLUMN_PRICE + " TEXT, " + COLUMN_SOLDE + " TEXT)";
        db.execSQL(userStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String userStatement = "DROP TABLE IF EXISTS " + TRANSACTION_TABLE ;
        db.execSQL(userStatement);

    }


    public boolean addTransaction(Transaction trs){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        cv.put(COLUMN_COMPTE,trs.getNumCompte());
        cv.put(COLUMN_ICON,trs.getIcon());
        cv.put(COLUMN_DATE,trs.getDate().toString());
        cv.put(COLUMN_LABEL,trs.getLabel());
        cv.put(COLUMN_PRICE,trs.getPrice());
        cv.put(COLUMN_REF,trs.getNumRef());
        cv.put(COLUMN_SOLDE,trs.getSold());


        long rs= db.insert(TRANSACTION_TABLE,null,cv);

        if(rs == -1){
            return  false;
        }else {
            return true;
        }
    }

    public ArrayList<Transaction> getAll(){

        ArrayList<Transaction> users= new ArrayList<Transaction>();

        String query="SELECT * FROM " + TRANSACTION_TABLE;
        SQLiteDatabase db= this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                Transaction user = new Transaction(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        Double.parseDouble(cursor.getString(6))
                );

                users.add(user);

            } while (cursor.moveToFirst());

        }else {
            //failure
        }

        cursor.close();
        db.close();

         return  users;
    }



    public Boolean checkEmailIfExist(String email){

       Boolean result = false;

        String query="SELECT * FROM " + TRANSACTION_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
              if(email.equals(cursor.getString(4))){
                  result = true;
                  break;
              }

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return result;
    }

    public Boolean checkPhoneIfExist(String phone){

        Boolean result = false;

        String query="SELECT * FROM " + TRANSACTION_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {

                System.out.println(cursor.getString(8));

                if(phone.equals(cursor.getString(8))){
                    result = true;
                    break;
                }

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return result;
    }



    public Boolean checkLogin(String email,String password){

        Boolean result = false;

        String query="SELECT * FROM " + TRANSACTION_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {



                if(email.equals(cursor.getString(4)) && password.equals(cursor.getString(9)) ){
                    result = true;
                    break;
                }

            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();

        return result;
    }


}
