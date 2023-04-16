package com.example.powiadomienia06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static int notificationId = 1;
    public static String Klucz = "Klucz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Nazwa kanału", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


        String odpowiedz = "Tutaj wpisz odpowiedź";
        RemoteInput remoteInput = new RemoteInput.Builder(Klucz)
                .setLabel(odpowiedz)
                .build();
        Intent intent = new Intent(this, DrugaAktywnosc.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        NotificationCompat.Action replyAction =
                new NotificationCompat.Action.Builder(
                        android.R.drawable.ic_dialog_info,
                        "Odpowiedz", pendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel_id")
                .setColor(ContextCompat.getColor(this,
                        R.color.black))
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie")
                .setContentText("Treść powiadomienia")
                .addAction(replyAction);
        NotificationManager notificationManager =
                (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification.build());

    }
}
