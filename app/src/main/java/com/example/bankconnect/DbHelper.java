package com.my.cv.builder.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.my.cv.builder.UserSettingActivity;
import com.my.cv.builder.entity.Certification;
import com.my.cv.builder.entity.Language;
import com.my.cv.builder.entity.Project;
import com.my.cv.builder.entity.Skill;
import com.my.cv.builder.entity.User;

import java.util.ArrayList;
import java.util.Date;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "database_cv_builder10.db";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String userStatement = "CREATE TABLE " + UserDbHelper.USER_TABLE + " (" + UserDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + UserDbHelper.COLUMN_FIRST_NAME + " TEXT," + UserDbHelper.COLUMN_LAST_NAME + " TEXT, " + UserDbHelper.COLUMN_BIRTHDAY + " DATE, " + UserDbHelper.COLUMN_EMAIL + " TEXT, " + UserDbHelper.COLUMN_CITY + " TEXT, " + UserDbHelper.COLUMN_COUNTRY + " TEXT, " + UserDbHelper.COLUMN_ADDRESS + " TEXT, " + UserDbHelper.COLUMN_PHONE + " TEXT, " + UserDbHelper.COLUMN_PASSWORD + " TEXT, " + UserDbHelper.COLUMN_ACTIVATED + " INT)";
        db.execSQL(userStatement);

        String formationStatement = "CREATE TABLE " + FormationDbHelper._TABLE + " (" + FormationDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + FormationDbHelper.COLUMN_TITLE + " TEXT," + FormationDbHelper.COLUMN_DATE_START + " TEXT, " + FormationDbHelper.COLUMN_DATE_END + " TEXT, " + FormationDbHelper.COLUMN_SCHOOL + " TEXT, " + FormationDbHelper.COLUMN_SUMMARY + " TEXT , " + FormationDbHelper.COLUMN_6 + " INTEGER )";
        db.execSQL(formationStatement);

        String experienceStatement = "CREATE TABLE " + ExperienceDbHelper._TABLE + " (" + ExperienceDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ExperienceDbHelper.COLUMN_1 + " TEXT," + ExperienceDbHelper.COLUMN_2 + " TEXT, " + ExperienceDbHelper.COLUMN_3 + " TEXT, " + ExperienceDbHelper.COLUMN_4 + " TEXT, " + ExperienceDbHelper.COLUMN_5 + " TEXT , " + ExperienceDbHelper.COLUMN_6 + " INTEGER  )";
        db.execSQL(experienceStatement);

        String certificationStatement = "CREATE TABLE " + CertificationDbHelper._TABLE + " (" + CertificationDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + CertificationDbHelper.COLUMN_1 + " TEXT," + CertificationDbHelper.COLUMN_2 + " TEXT, " + CertificationDbHelper.COLUMN_3 + " TEXT, " + CertificationDbHelper.COLUMN_4 + " TEXT, " + CertificationDbHelper.COLUMN_5 + " TEXT, " + CertificationDbHelper.COLUMN_6 + " INTEGER )";
        db.execSQL(certificationStatement);

        String projectStatement = "CREATE TABLE " + ProjectDbHelper._TABLE + " (" + ProjectDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ProjectDbHelper.COLUMN_1 + " TEXT," + ProjectDbHelper.COLUMN_2 + " TEXT, " + ProjectDbHelper.COLUMN_3 + " TEXT, " + ProjectDbHelper.COLUMN_4 + " TEXT, " + ProjectDbHelper.COLUMN_5 + " TEXT, " + ProjectDbHelper.COLUMN_6 + " INTEGER )";
        db.execSQL(projectStatement);

        String skillStatement = "CREATE TABLE " + SkillDbHelper._TABLE + " (" + SkillDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + SkillDbHelper.COLUMN_1 + " TEXT," + SkillDbHelper.COLUMN_2 + " TEXT," + SkillDbHelper.COLUMN_3 + " INTEGER )";
        db.execSQL(skillStatement);

        String languageStatement = "CREATE TABLE " + LanguageDbHelper._TABLE + " (" + LanguageDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + LanguageDbHelper.COLUMN_1 + " TEXT," + LanguageDbHelper.COLUMN_2 + " TEXT," + LanguageDbHelper.COLUMN_3 + " INTEGER )";
        db.execSQL(languageStatement);

        String HobbyStatement = "CREATE TABLE " + HobbyDbHelper._TABLE + " (" + HobbyDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + HobbyDbHelper.COLUMN_1 + " TEXT," + HobbyDbHelper.COLUMN_2 + " TEXT," + HobbyDbHelper.COLUMN_3 + " INTEGER )";
        db.execSQL(HobbyStatement);

        String tempStatement = "CREATE TABLE " + ModelTemplateDbHelper._TABLE + " (" + ModelTemplateDbHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ModelTemplateDbHelper.COLUMN_1 + " TEXT," + ModelTemplateDbHelper.COLUMN_2 + " INTEGER," + ModelTemplateDbHelper.COLUMN_3 + " INTEGER," + ModelTemplateDbHelper.COLUMN_4 + " INTEGER," + ModelTemplateDbHelper.COLUMN_5 + " INTEGER," + ModelTemplateDbHelper.COLUMN_6 + " INTEGER," + ModelTemplateDbHelper.COLUMN_7 + " INTEGER," + ModelTemplateDbHelper.COLUMN_8 + " REAL," + ModelTemplateDbHelper.COLUMN_9 + " REAL," + ModelTemplateDbHelper.COLUMN_10 + " NUMERIC , " + ModelTemplateDbHelper.COLUMN_11 + " NUMERIC," + ModelTemplateDbHelper.COLUMN_12 + " NUMERIC," + ModelTemplateDbHelper.COLUMN_13 + " NUMERIC," + ModelTemplateDbHelper.COLUMN_14 + " NUMERIC," + ModelTemplateDbHelper.COLUMN_15 + " NUMERIC," + ModelTemplateDbHelper.COLUMN_16 + " NUMERIC," + ModelTemplateDbHelper.COLUMN_17 + " TEXT," + ModelTemplateDbHelper.COLUMN_18 + " TEXT," + ModelTemplateDbHelper.COLUMN_19 + " TEXT," + ModelTemplateDbHelper.COLUMN_20 + " TEXT," + ModelTemplateDbHelper.COLUMN_21 + " TEXT," + ModelTemplateDbHelper.COLUMN_22 + " TEXT," + ModelTemplateDbHelper.COLUMN_23 + " TEXT," + ModelTemplateDbHelper.COLUMN_24 + " TEXT," + ModelTemplateDbHelper.COLUMN_25 + " TEXT," + ModelTemplateDbHelper.COLUMN_26 + " TEXT," + ModelTemplateDbHelper.COLUMN_27 + " TEXT," + ModelTemplateDbHelper.COLUMN_28 + " TEXT," + ModelTemplateDbHelper.COLUMN_29 + " TEXT," + ModelTemplateDbHelper.COLUMN_30 + " TEXT," + ModelTemplateDbHelper.COLUMN_31 + " TEXT," + ModelTemplateDbHelper.COLUMN_32 + " TEXT," + ModelTemplateDbHelper.COLUMN_33 + " TEXT," + ModelTemplateDbHelper.COLUMN_34 + " TEXT," + ModelTemplateDbHelper.COLUMN_35 + " TEXT," + ModelTemplateDbHelper.COLUMN_36 + " TEXT," + ModelTemplateDbHelper.COLUMN_37 + " TEXT," + ModelTemplateDbHelper.COLUMN_38 + " INTEGER," + ModelTemplateDbHelper.COLUMN_39 + " TEXT," + ModelTemplateDbHelper.COLUMN_40 + " TEXT," + ModelTemplateDbHelper.COLUMN_41 + " TEXT," + ModelTemplateDbHelper.COLUMN_42 + " INTEGER)";
        db.execSQL(tempStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String userStatement = "DROP TABLE IF EXISTS " + UserDbHelper.USER_TABLE;
        db.execSQL(userStatement);

    }

}
