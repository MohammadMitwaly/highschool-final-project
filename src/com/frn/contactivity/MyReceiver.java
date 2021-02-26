package com.frn.contactivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class MyReceiver extends ResultReceiver{
	 private Receiver receiver;
	 
	 
	//constructor
	public MyReceiver(Handler handler) {
	      super(handler);
	  }
	// Setter for assigning the receiver
	public void setReceiver(Receiver receiver) {
	      this.receiver = receiver;
	  }
	
	// Defines our event interface for communication
	  public interface Receiver {
	      public void onReceiveResult(int resultCode, Bundle resultData);
	  }
	  
	  @Override
	  protected void onReceiveResult(int resultCode, Bundle resultData) {
	      if (receiver != null) {
	        receiver.onReceiveResult(resultCode, resultData);
	      }
	  }
	  
	  

	
	
	
	

}
