package com.example.listview01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, wojewodztwa);

    final ListView listView = (ListView) findViewById(R.id.listView);
    TextView header = new TextView(this);
header.setTextSize(25);
header.setTextColor(Color.parseColor("#975A5A"));

header.setText("Lista województw:");
header.setTypeface(header.getTypeface(), Typeface.BOLD);
listView.addHeaderView(header);
listView.setAdapter(adapter);
listView.setOnItemClickListener(new
        AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            Object listItem = parent.getItemAtPosition(position);
            if (listItem != null)
                Toast.makeText(getBaseContext(), id + 1 +". " +
                        listItem.toString(), Toast.LENGTH_SHORT).show();

        }
    });
}
}