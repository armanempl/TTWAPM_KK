package com.example.intencje02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DrugaAktywnosc extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga_aktywnosc);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String napis = bundle.getString("Imie");
            int liczba = bundle.getInt("Wiek");
            Toast.makeText(this, napis + " ma " + liczba + " lat",
                    Toast.LENGTH_SHORT).show();

        }

    }
}
