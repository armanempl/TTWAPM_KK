package com.example.sqlite01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void onClick(View view) {
            ArrayList<String> wyniki = new ArrayList<String>();
            Cursor cursor = db.rawQuery("SELECT `Id`, `Imie`, `Nazwisko` FROM `Studenci`",null);
            String sqlStudent = "INSERT INTO STUDENCI VALUES ('', 'Pawel','Jumper')";
            SQLiteStatement statement = db.compileStatement(sqlStudent);

            db.rawQuery("INSERT INTO `Studenci` VALUES ('', 'Jan', 'Nowak')", null);
            db.rawQuery("INSERT INTO `Studenci` VALUES ('', 'Kamil', 'Ślimak')", null);
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("Id"));
                    @SuppressLint("Range") String imie = cursor.getString(cursor.getColumnIndex("Imie"));
                    @SuppressLint("Range") String nazwisko = cursor.getString(cursor.getColumnIndex("Nazwisko"));
                    wyniki.add("Id: " + id + ", Imię: " + imie + ",Nazwisko: " + nazwisko);
                } while (cursor.moveToNext());
            }
            ListView listView = (ListView)findViewById(R.id.listView);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, wyniki);

            cursor.close();
        }
    }


                /*db = openOrCreateDatabase("Akademia", MODE_PRIVATE, null);
        String query1 = "CREATE TABLE IF NOT EXISTS `Studenci` (`Id` INTEGER,`Imie` VARCHAR, `Nazwisko` VARCHAR);";
        db.execSQL(query1);
        String query2 = "INSERT INTO `Studenci` VALUES('', 'Kamil','Ślimak');";
        db.execSQL(query2);
        String query3 = "SELECT COUNT(*) FROM `Studenci`;";
        db.execSQL(query3);
        String query4 = "SELECT * FROM `Studenci` WHERE `Id` = '1'";
        Cursor rawQuery = db.rawQuery(query4, null);
        rawQuery.moveToFirst();
        //int getInt(int columnindex);*/
