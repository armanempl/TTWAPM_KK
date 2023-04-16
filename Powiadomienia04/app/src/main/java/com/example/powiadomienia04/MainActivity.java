package com.example.powiadomienia04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMin(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Nazwa kanału", NotificationManager.IMPORTANCE_MIN);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Priorytet minimalny")
                .setContentText("Nic ważnego");


        NotificationManager notificationManager =(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        int id = 1;
        notificationManager.notify(id, notification.build());
    }
    public void onClickNormal(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id1", "Nazwa kanału", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel_id1")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Priorytet normalny")
                .setContentText("Sytuacja normalna");

        NotificationManager notificationManager =(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        int id = 2;
        notificationManager.notify(id, notification.build());
    }
    public void onClickHigh(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id2", "Nazwa kanału", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel_id2")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Priorytet wysoki")
                .setContentText("Coś ważnego");

        NotificationManager notificationManager =(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        int id = 3;
        notificationManager.notify(id, notification.build());
    }

}