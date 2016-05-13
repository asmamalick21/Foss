package com.example.user.alarmclock;

import android.app.NotificationManager;

import android.app.PendingIntent;

import android.content.Context;

import android.content.Intent;

import android.media.Ringtone;

import android.media.RingtoneManager;

import android.net.Uri;

import android.support.v4.app.NotificationCompat;

import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends WakefulBroadcastReceiver {

    Ringtone ringtone;

    @Override

    public void onReceive(final Context context, Intent intent) {

        sendNotification(context , "....Tring Tring....");

        MainActivity.getTextView2().setText("Alarm ringing");

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        ringtone = RingtoneManager.getRingtone(context, uri);

        ringtone.play();

    }

    private void sendNotification(Context context ,String msg) {

        NotificationManager mNotificationManager = (NotificationManager)

                context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,

                new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =

                new NotificationCompat.Builder(context)

                        .setSmallIcon(R.mipmap.ic_launcher)

                        .bigText(msg))

        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);

        mNotificationManager.notify(1547, mBuilder.build());

    }

}
