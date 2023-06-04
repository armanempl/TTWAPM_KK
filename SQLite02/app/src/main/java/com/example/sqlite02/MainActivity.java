package com.example.sqlite02;

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
        db = openOrCreateDatabase("Akademia", MODE_PRIVATE, null);

        // Przygotowanie zapytania SQL, które utworzy tabelę STUDENCI
        String sqlDB = "CREATE TABLE IF NOT EXISTS STUDENCI (Id INTEGER, Imie VARCHAR, Nazwisko VARCHAR)";
        db.execSQL(sqlDB);
    }

    public void onClick(View view) {
        // Dodawanie użytkownika Jan Kowalski do tabeli STUDENCI
        String sqlStudent = "INSERT INTO STUDENCI VALUES (?, ?, ?), (?,?,?), (?,?,?)";
        SQLiteStatement statement = db.compileStatement(sqlStudent);

        // Ustawianie wartości dla parametrów zapytania parametrycznego
        statement.bindLong(1, 1);
        statement.bindString(2, "Paweł");
        statement.bindString(3, "Pierwszy");

        statement.bindLong(4, 2);
        statement.bindString(5, "Adam");
        statement.bindString(6, "Drugi");

        statement.bindLong(7, 3);
        statement.bindString(8, "Kamil");
        statement.bindString(9, "Trzeci");

        statement.executeInsert();

        // Pobieranie wszystkich wierszy z tabeli Studenci
        ArrayList<String> wyniki = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT DISTINCT `Id`, `Imie`, `Nazwisko` FROM STUDENCI WHERE `Id` == 3", null);

        // Sprawdzanie, czy tabela ma rekordy
        if (c.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("Id"));
                @SuppressLint("Range") String imie = c.getString(c.getColumnIndex("Imie"));
                @SuppressLint("Range") String nazwisko = c.getString(c.getColumnIndex("Nazwisko"));

                // Dodawanie wartości do listy wyników
                wyniki.add("Wypisanie danych o id 3: \n Id: " + id + ", Imię: " + imie + ", Nazwisko: " + nazwisko);
            } while (c.moveToNext());
        }

        // Ustawienie adaptera dla kontrolki ListView
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wyniki);
        listView.setAdapter(adapter);


        // Zamknięcie kursora
        c.close();

    }

    public void onClick2(View view) {
        // Drugie zapytanie
        // Pobieranie wszystkich wierszy z tabeli Studenci
        ArrayList<String> wyniki2 = new ArrayList<>();
        Cursor c2 = db.rawQuery("SELECT DISTINCT `Id`, `Imie`, `Nazwisko` FROM STUDENCI ORDER BY `Id` DESC", null);

        // Sprawdzanie, czy tabela ma rekordy
        if (c2.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = c2.getInt(c2.getColumnIndex("Id"));
                @SuppressLint("Range") String imie = c2.getString(c2.getColumnIndex("Imie"));
                @SuppressLint("Range") String nazwisko = c2.getString(c2.getColumnIndex("Nazwisko"));

                // Dodawanie wartości do listy wyników
                wyniki2.add("Id: " + id + ", Imię: " + imie + ", Nazwisko: " + nazwisko);
            } while (c2.moveToNext());
        }

        // Ustawienie adaptera dla kontrolki ListView
        ListView listView2 = findViewById(R.id.listView2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wyniki2);
        listView2.setAdapter(adapter2);
        c2.close();
    }
    }