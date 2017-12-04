package com.andrei_dev.SQLite;

/**
 * Created by Sergey on 30.12.2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ControlSQL extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "regular_schedule";
    public static final String TABLE_SCHEDULE = "regular_schedule";

    public static final String KEY_ID = "_id";
    public static final String KEY_DAY = "day";
    public static final String KEY_SUBJECT = "subject";
    public static final String KEY_PAIR = "pair";


    // формируем запрос для создания базы данных
    private static final String DATABASE_CREATE = "create table "
            +  TABLE_SCHEDULE+ "(" + KEY_ID
            + " integer primary key autoincrement, " + KEY_DAY
            + " text not null, " +  KEY_SUBJECT + " text not null,"
            + KEY_PAIR + " text not null" + ");";


    public ControlSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //создаем таблицу
        db.execSQL(DATABASE_CREATE);

        //добавляем строку
        ContentValues initialValues = createContentValues("","","");
        db.insert(TABLE_SCHEDULE, null, initialValues);

Log.d("Insert", "xxxx");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS table1");
        onCreate(db);
    }



    /**
     * Создаёт новый контакт. Если создан успешно - возвращается
     * номер строки rowId, иначе -1
     */
    public long createNewTable(String FIO, String DOL,
                               String TEL) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues initialValues = createContentValues(FIO, DOL,
                TEL);

        long row = db.insert(TABLE_SCHEDULE, null, initialValues);
        db.close();

        return row;
    }


    /**
     * Изменение строчки
     */
    public boolean updateTable(long rowId, String FIO, String DOL,
                               String TEL) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updateValues = createContentValues(FIO, DOL,
                TEL);

        return db.update(TABLE_SCHEDULE, updateValues, KEY_ID+ "=" + rowId,
                null) > 0;
    }

    /**
     * Удаление контакта
     */
    public void deleteTable(long rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCHEDULE, KEY_ID + "=" + rowId, null);
        db.close();
    }

    /**
     * Получение всех контактов
     */
    public Cursor getFullTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(TABLE_SCHEDULE, new String[] { KEY_ID,
                        KEY_DAY, KEY_SUBJECT, KEY_PAIR }, null,
                null, null, null, null);
    }

    /**
     * Получаем конктеный контакт
     */
    public Cursor getTable(long rowId) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.query(true, TABLE_SCHEDULE,
                new String[] { KEY_ID, KEY_DAY, KEY_SUBJECT,
                        KEY_PAIR }, KEY_ID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    /*
     * Описываем структуру данных
     */
    private ContentValues createContentValues(String FIO, String DOL,
                                              String TEL) {
        ContentValues values = new ContentValues();
        values.put(KEY_DAY, FIO);
        values.put(KEY_SUBJECT, DOL);
        values.put( KEY_PAIR, TEL);
        return values;
    }






}
