package com.mateuszgabrynowicz.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mateusz on 2017-02-09.
 */

public class Alarm extends WakefulBroadcastReceiver
{
    private static final String TAG = "Alarm";
    @Override
    public void onReceive(Context context, Intent intent)
    {

        // Put here YOUR code.
        Toast.makeText(context, "Alarm !!!!!!!!!!", Toast.LENGTH_LONG).show(); // For example
        Log.d(TAG, "onReceive: ALARM!!!!!!");
        Intent launchIntent = new Intent();
        launchIntent.setComponent(new ComponentName("com.mateuszgabrynowicz.alarmapp", "com.mateuszgabrynowicz.alarmapp.MainActivity"));
        launchIntent.setAction("android.intent.action.MAIN");
        launchIntent.addCategory("android.intent.category.LAUNCHER");
        context.startActivity(launchIntent);


    }

    public void setAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 10 , pi); // Millisec * Second * Minute
        Log.d(TAG, "setAlarm: starting alarm");
    }

    public void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}