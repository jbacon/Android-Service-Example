package app.keylogger;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	
	private static final String TAG = "Keylogger.MyService";
	
	private Handler handler;
	private Timer timer;

	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "onBind()");
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startID) {
		Log.i(TAG, "onStart()");
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "onCreate()");
		handler = new Handler();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				handler.post(new Runnable() {
					public void run() {
						Log.i(TAG, "Post from handler and executeTimer");
						Toast.makeText(MyService.this,"BUTTER TOAST!", Toast.LENGTH_SHORT).show();
					}
				});
			}
		};
		timer = new Timer("MyService");
		timer.scheduleAtFixedRate(timerTask, 0, 2000);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.i(TAG, "onDestroy()");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand()");
		return START_STICKY;
	}
}
