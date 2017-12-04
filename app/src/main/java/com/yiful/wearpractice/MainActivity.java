package com.yiful.wearpractice;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_LONG).show();
                int notificationId = 101;
                // Build intent for notification content
                Intent viewIntent = new Intent(MainActivity.this, SecondActivity.class);
                PendingIntent viewPendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, viewIntent, 0);
                //Building notification layout
                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Demo")
                                .setContentText("It's demo of simple notification")
                                .setContentIntent(viewPendingIntent);

                // instance of the NotificationManager service
                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(MainActivity.this);

                // Build the notification and notify it using notification manager.
                notificationManager.notify(notificationId, notificationBuilder.build());
            }
        });
    }
}
