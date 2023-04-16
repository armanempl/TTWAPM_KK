package com.example.powiadomienia06;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

public class DrugaAktywnosc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga_aktywnosc);
        Intent intent = getIntent();
        Bundle bundle = RemoteInput.getResultsFromIntent(intent);
        if (bundle!= null) {
            TextView textView = (TextView) findViewById(R.id.textView);
            String tekst = bundle.getString(MainActivity.Klucz);
            textView.setText(tekst);
            NotificationManager notificationManager =
                    (NotificationManager)
                            getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(MainActivity.notificationId);
        }
    }
}
