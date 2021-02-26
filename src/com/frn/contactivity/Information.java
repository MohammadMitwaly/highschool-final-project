package com.frn.contactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class Information extends Activity {
	
	EditText  etUsername, etMainEmail, etSecondaryEmail,etMainPhone, etSecondaryPhone, etPassword;
	String username, mainemail, secondaryemail, mainphone, secondaryphone, password;
	Button btEdit;
	DatabaseHelper helper = new DatabaseHelper(this);
	User c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etUsername = (EditText) findViewById(R.id.etUsername);
		etMainEmail = (EditText) findViewById(R.id.etMainEmail);
		etSecondaryEmail = (EditText) findViewById(R.id.etSecondaryEmail);
		etMainPhone = (EditText) findViewById(R.id.etMainPhone);
		etSecondaryPhone = (EditText)  findViewById(R.id.etSecondaryPhone);
		etPassword = (EditText)  findViewById(R.id.etPassword);
		btEdit = (Button) findViewById(R.id.btEdit);
		etMainPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		etSecondaryPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		Bundle bundle = getIntent().getExtras();
		
		if (bundle != null)
		{
			String Username = bundle.getString(username);
			String MainEmail = helper.searchMainEmail(Username);
			String SecondaryEmail = helper.searchSecondaryEmail(Username);
			String MainPhone = helper.searchMainPhone(Username);
			String SecondaryPhone = helper.searchSecondaryPhone(Username);
			String Password = helper.searchPassword(Username);
			etUsername.setText(Username);
			etMainEmail.setText(MainEmail);
			etSecondaryEmail.setText(SecondaryEmail);
			etMainPhone.setText(MainPhone);
			etSecondaryPhone.setText(SecondaryPhone);
			etPassword.setText(Password);	
		}
		
	}
	
	
	
	
}
