package com.example.powiadomienia05;

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

    public void onClick(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Nazwa kanału", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        String groupKey = "Moja Grupa";
        NotificationCompat.Builder notification0 = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Powiadomienie grupowe")
                .setContentText("Masz 3 nowe powiadomienia")
                .setGroup(groupKey)
                .setGroupSummary(true);

        NotificationCompat.Builder notification1 = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("To jest 1. powiadomienie")
                .setGroup(groupKey);

        NotificationCompat.Builder notification2 = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("To jest 2. powiadomienie")
                .setGroup(groupKey);

        NotificationCompat.Builder notification3 = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("To jest 3. powiadomienie")
                .setGroup(groupKey);

        NotificationManager notifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int Id0 = 0;
        int Id1 = 1;
        int Id2 = 2;
        int Id3 = 3;
        notifyMgr.notify(Id1, notification1.build());
        notifyMgr.notify(Id2, notification2.build());
        notifyMgr.notify(Id3, notification3.build());
        notifyMgr.notify(Id0, notification0.build());
    }

}