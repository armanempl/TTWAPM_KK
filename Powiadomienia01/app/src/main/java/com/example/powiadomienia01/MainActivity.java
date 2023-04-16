package com.example.powiadomienia01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick (View view){
        Intent drugaAktywnosc = new Intent(this, DrugaAktywnosc.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                drugaAktywnosc, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri dzwonek = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);



        Notification.Builder notification = new Notification.Builder(this, "channel_id")
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Powiadomienie")
                    .setContentText("Coś się stało")
                    .setSound(dzwonek)
                    .setContentIntent(pendingIntent)
                .build();
        NotificationManager notificationManager =(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        int id = 1;
        notificationManager.notify(id, notification);


    }
}
