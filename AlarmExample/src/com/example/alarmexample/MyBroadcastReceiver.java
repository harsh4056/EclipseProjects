package com.example.alarmexample;






import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;



public class MyBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Time is up!!!!.",
				Toast.LENGTH_LONG).show();
		// Vibrate the mobile phone
		 Intent ll24Service = new Intent(context, MyService.class);
	        context.startService(ll24Service);
		Vibrator vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);
	
	}
	
}
