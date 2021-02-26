package com.frn.contactivity;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.content.WakefulBroadcastReceiver;

public class MyService extends IntentService{
	public static final String ACTION = "com.codepath.example.servicesdemo.MyTestService";
	
	public MyService(){
		super("MyService");
	}

	@Override
    public void onCreate() {
        super.onCreate(); 
    }
	
	 @Override
	    protected void onHandleIntent(Intent intent) {
	        // This describes what will happen when service is triggered
		// Fetch data passed into the intent on start
	      String val = intent.getStringExtra("foo");
	      // Construct an Intent tying it to the ACTION (arbitrary event namespace)
	      Intent in = new Intent(ACTION);
	      // Put extras into the intent as usual
	      in.putExtra("resultCode", Activity.RESULT_OK);
	      in.putExtra("resultValue", "My Result Value. Passed in: " + val);
	      // Fire the broadcast with intent packaged
	      LocalBroadcastManager.getInstance(this).sendBroadcast(in);
	      // or sendBroadcast(in) for a normal broadcast;
	      WakefulBroadcastReceiver.completeWakefulIntent(intent);
	    }
	 
	 
	
}
