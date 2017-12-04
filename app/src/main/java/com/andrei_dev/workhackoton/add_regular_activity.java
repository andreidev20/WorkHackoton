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
        selection = (TextView) findViewById(R.id.selection);

        Spinner Days = (Spinner) findViewById(R.id.Day);

        Spinner Pair = (Spinner) findViewById(R.id.Pair);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);

        ArrayAdapter<Byte> adapter3 = new ArrayAdapter<Byte>(this, android.R.layout.simple_spinner_item, pairs);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Days.setAdapter(adapter1);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Pair.setAdapter(adapter3);
    }
    OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            // Получаем выбранный объект
            String item = (String)parent.getItemAtPosition(position);
            selection.setText(item);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
        spinner.setOnItemSelectedListener(itemSelectedListener);
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







