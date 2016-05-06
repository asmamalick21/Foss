package com.example.user.alarmclock;

import android.app.Service;

import android.content.Intent;

import android.media.Ringtone;

import android.media.RingtoneManager;

import android.net.Uri;

import android.os.IBinder;

import android.support.annotation.Nullable;

import java.security.Provider;

public class Play extends Service

{

    private Ringtone ringtone;

    @Override

    public IBinder onBind(Intent intent)

    {

        return null;

    }

    @Override

    public int onStartCommand(Intent intent, int flags, int startId)

    {

        Uri ringtoneUri = Uri.parse(intent.getExtras().getString("ringtone-uri"));

        this.ringtone = RingtoneManager.getRingtone(this, ringtoneUri);

        ringtone.play();

        return START_STICKY;

    }

    @Override

    public void onDestroy()

    {

        ringtone.stop();

    }

}