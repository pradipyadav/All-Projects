package com.example.statusbarjava;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    public static final int NOTIFICATION_SAMPLE=1235;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void fire(View view){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
        .setContentInfo("Content Info")
                .setContentText("Hi Pradip")
                .setContentTitle("Notification")
                .setDefaults(Notification.DEFAULT_ALL)
//                .setOngoing(true)
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification= builder.build();
        manager.notify(NOTIFICATION_SAMPLE,notification);
    }
}
