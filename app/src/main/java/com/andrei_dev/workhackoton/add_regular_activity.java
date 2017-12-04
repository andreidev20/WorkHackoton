package com.andrei_dev.workhackoton;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.andrei_dev.SQLite.DBHelper;

public class add_regular_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_regular_activity);
    }

    public void onClick(View v) {

            String day = ;
            String subject = ;
            String pair=;

        DBHelper dbHelper;
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        switch (v.getId()) {

            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_DAY, day);
                contentValues.put(DBHelper.KEY_SUBJECT, subject);
                contentValues.put(DBHelper.KEY_PAIR, pair);

                database.insert(DBHelper.TABLE_SCHEDULE, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_SCHEDULE, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int dayIndex = cursor.getColumnIndex(DBHelper.KEY_DAY);
                    int subjectIndex = cursor.getColumnIndex(DBHelper.KEY_SUBJECT);
                    int pairIndex = cursor.getColumnIndex(DBHelper.KEY_PAIR);
                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", day = " + cursor.getString(dayIndex) +
                                ", subject = " + cursor.getString(subjectIndex)+
                                ", pair = "+ cursor.getString(pairIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
                break;

            case R.id.btnClear:
                database.delete(DBHelper.TABLE_SCHEDULE, null, null);
                break;
        }
        dbHelper.close();
    }
}
}

