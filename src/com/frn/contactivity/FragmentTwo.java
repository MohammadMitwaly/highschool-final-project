package com.frn.contactivity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentTwo extends Fragment {
	   Button sendBtn;
	   EditText txtphoneNo;
	   EditText txtMessage;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
		View rootView = inflater.inflate(R.layout.fragment_two , container, false);
		sendBtn = (Button) rootView.findViewById(R.id.btnSendSMS);
	      txtphoneNo = (EditText) rootView.findViewById(R.id.editText);
	      txtMessage = (EditText) rootView.findViewById(R.id.editText2);
	   
	      sendBtn.setOnClickListener(new View.OnClickListener() {
	          public void onClick(View view) {
	             sendSMSMessage();
	          }
	       });
		return rootView;
	    }
	    protected void sendSMSMessage() {
	       Log.i("Send SMS", "");
	       String phoneNo = txtphoneNo.getText().toString();
	       String message = txtMessage.getText().toString();
	       
	       try {
	          SmsManager smsManager = SmsManager.getDefault();
	          smsManager.sendTextMessage(phoneNo, null, message, null, null);
	          Toast.makeText(getActivity().getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
	       } 
	       
	       catch (Exception e) {
	          Toast.makeText(getActivity().getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
	          e.printStackTrace();
	       }
	    }
	    
	    
		
 

}