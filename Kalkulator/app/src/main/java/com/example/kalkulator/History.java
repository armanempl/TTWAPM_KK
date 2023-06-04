package com.example.kalkulator;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;


public class History extends AppCompatActivity {
    private List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Odczytywanie listy z dodatkowych danych intencji
        lista = getIntent().getStringArrayListExtra("lista");

        // Wypisywanie zawartości listy
        TextView textView = findViewById(R.id.textView);
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : lista) {
            stringBuilder.append(element).append("\n");
        }
        textView.setText(stringBuilder.toString());
    }
}

