package com.mateuszgabrynowicz.alarmapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Mateusz on 2017-02-09.
 */


public class AlarmService extends Service
{
    private static final String TAG = "AlarmService";
    Alarm alarm = new Alarm();
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        alarm.setAlarm(this);
        Log.d(TAG, "onStartCommand: service starting alarm");


        return START_STICKY;
    }



    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}