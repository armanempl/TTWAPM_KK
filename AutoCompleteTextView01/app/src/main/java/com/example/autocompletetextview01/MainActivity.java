package com.example.autocompletetextview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private static final String[] wojewodztwa = {
            "dolnośląskie",
            "kujawsko-pomorskie",
            "lubelskie",
            "lubuskie",
            "łódzkie",
            "małopolskie",
            "mazowieckie",
            "opolskie",
            "podkarpackie",
            "podlaskie",
            "pomorskie",
            "śląskie",
            "świętokrzyskie",
            "warmińsko-mazurskie",
            "wielkopolskie",
            "zachodniopomorskie"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, wojewodztwa);
        AutoCompleteTextView textView1 = (AutoCompleteTextView)
                findViewById(R.id.textView1);
        textView1.setAdapter(adapter);
        MultiAutoCompleteTextView textView2 = (MultiAutoCompleteTextView)
                findViewById(R.id.textView2);
        textView2.setAdapter(adapter);
        textView2.setTokenizer(
                new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
