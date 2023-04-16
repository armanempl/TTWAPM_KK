package com.example.powiadomienia03;

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

        NotificationCompat.InboxStyle inboxStyle = new
                NotificationCompat.InboxStyle();
        String[] zdarzenia =
                {"Zdarzenie 1", "Zdarzenie 2", "Zdarzenie 3", "Zdarzenie 4"};
        inboxStyle.setBigContentTitle("Szczegóły zdarzenia");
        for (int i=0; i < zdarzenia.length; i++) {
            inboxStyle.addLine(zdarzenia[i]);
        }
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Powiadomienie")
                .setContentText("Wiadomość powiadomienia")
                .setStyle(inboxStyle);

        NotificationManager notificationManager =(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        int id = 1;
        notificationManager.notify(id, notification.build());
    }
}