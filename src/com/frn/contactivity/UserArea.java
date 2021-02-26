package com.frn.contactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.widget.EditText;



public class UserArea extends Activity {
	
	EditText  etUsername, etMainEmail, etSecondaryEmail,etMainPhone, etSecondaryPhone;
	String username, mainemail, secondaryemail, mainphone, secondaryphone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etUsername = (EditText) findViewById(R.id.etUsername);
		etMainEmail = (EditText) findViewById(R.id.etMainEmail);
		etSecondaryEmail = (EditText) findViewById(R.id.etSecondaryEmail);
		etMainPhone = (EditText) findViewById(R.id.etMainPhone);
		etSecondaryPhone = (EditText) findViewById(R.id.etSecondaryPhone);
		etMainPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		etSecondaryPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		
		Intent myintent = getIntent();
		username = myintent.getStringExtra("username");
		mainemail = myintent.getStringExtra("mainemail");
		secondaryemail = myintent.getStringExtra("secondaryemail");
		mainphone = myintent.getStringExtra("mainphone");
	    secondaryphone = myintent.getStringExtra("secondaryphone");
		
	
		

		
		
	}

	
}
