package com.andrei_dev.SQLite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "regular_schedule";
    public static final String TABLE_SCHEDULE = "regular_schedule";

    public static final String KEY_ID = "_id";
    public static final String KEY_DAY = "day";
    public static final String KEY_SUBJECT = "subject";
    public static final String KEY_PAIR = "pair";
    public DBHelper(Context context) {
        super((android.content.Context) context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_SCHEDULE+ "(" + KEY_ID
                + " integer primary key," + KEY_DAY + " text," + KEY_SUBJECT + " text" + KEY_PAIR+"text"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_SCHEDULE);

        onCreate(db);

    }
}