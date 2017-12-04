package com.andrei_dev.workhackoton;

import android.content.ClipboardManager;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import com.andrei_dev.SQLite.DBHelper;


public class add_regular_activity extends AppCompatActivity {
    DBHelper dbHelper;
    String[] days = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};

    EditText subjects;
    Byte[] pairs = {1, 2, 3, 4, 5, 6, 7, 8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_regular_activity);

        dbHelper = new DBHelper(this);


        Spinner Days = (Spinner) findViewById(R.id.Day);

        Spinner Pair = (Spinner) findViewById(R.id.Pair);

        // адаптер
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<Byte> adapter1 = new ArrayAdapter<Byte>(this, android.R.layout.simple_spinner_item, pairs);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Pair.setAdapter(adapter1);
        Days.setAdapter(adapter2);
        // заголовок
        Days.setPrompt("Title");
        // выделяем элемент
        Days.setSelection(0);
        // устанавливаем обработчик нажатия
        Days.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Pair.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}














//    public void onClick(View v) {
//
//            String day = ;
//            String subject = ;
//            String pair=;
//
//
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//
//
//        switch (v.getId()) {
//
//            case R.id.btnAdd:
//                contentValues.put(DBHelper.KEY_DAY, day);
//                contentValues.put(DBHelper.KEY_SUBJECT, subject);
//                contentValues.put(DBHelper.KEY_PAIR, pair);
//
//                database.insert(DBHelper.TABLE_SCHEDULE, null, contentValues);
//                break;
//
//            case R.id.btnRead:
//                Cursor cursor = database.query(DBHelper.TABLE_SCHEDULE, null, null, null, null, null, null);
//
//                if (cursor.moveToFirst()) {
//                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
//                    int dayIndex = cursor.getColumnIndex(DBHelper.KEY_DAY);
//                    int subjectIndex = cursor.getColumnIndex(DBHelper.KEY_SUBJECT);
//                    int pairIndex = cursor.getColumnIndex(DBHelper.KEY_PAIR);
//                    do {
//                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
//                                ", day = " + cursor.getString(dayIndex) +
//                                ", subject = " + cursor.getString(subjectIndex)+
//                                ", pair = "+ cursor.getString(pairIndex));
//                    } while (cursor.moveToNext());
//                } else
//                    Log.d("mLog","0 rows");
//
//                cursor.close();
//                break;
//
//            case R.id.btnClear:
//                database.delete(DBHelper.TABLE_SCHEDULE, null, null);
//                break;
//        }
//        dbHelper.close();
//    }
//}








