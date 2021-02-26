package com.frn.contactivity;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends Activity {
	EditText etUsername, etMainEmail, etSecondaryEmail,etMainPhone, etSecondaryPhone,  etPassword;
	 Button btSignUp;
	 DatabaseHelper helper = new DatabaseHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		etUsername = (EditText) findViewById(R.id.etUsername);
		etMainEmail = (EditText) findViewById(R.id.etMainEmail);
		etSecondaryEmail = (EditText) findViewById(R.id.etSecondaryEmail);
		etMainPhone = (EditText) findViewById(R.id.etMainPhone);
		etSecondaryPhone = (EditText) findViewById(R.id.etSecondaryPhone);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btSignUp = (Button) findViewById(R.id.btSignUp);
		etMainPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		etSecondaryPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		

		
		btSignUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = etUsername.getText().toString();
				String mainemail = etMainEmail.getText().toString();
				String secondaryemail = etSecondaryEmail.getText().toString();
				String mainphone = etMainPhone.getText().toString();
				String secondaryphone = etSecondaryPhone.getText().toString();
				String password = etPassword.getText().toString();
				
				if(username.equals("") || mainemail.equals("") || secondaryemail.equals("") || mainphone.equals("") || secondaryphone.equals("") || password.equals(""))
				{
					AlertDialog.Builder bu1lder = new AlertDialog.Builder(SignUp.this);
					bu1lder.setMessage("All Fields Must Be Filled")
					.setNegativeButton("OK", null)
					.create()
					.show();
					
				}
				
				else
				{
				User c = new User();
				c.setUsername(username);
				c.setMainEmail(mainemail);
				c.setSecondaryEmail(secondaryemail);
				c.setMainPhone(mainphone);
				c.setSecondaryPhone(secondaryphone);
				c.setPassword(password);
				
				final boolean b = helper.insertUser(c);
				
				
				Response.Listener<String> responselistener = new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						try {
							JSONObject jsonResponse = new JSONObject(response);
							boolean success = jsonResponse.getBoolean("success");
							
							if(b)
							{
								Intent myintent = new Intent(SignUp.this, Login.class);
								SignUp.this.startActivity(myintent);
							}
							else{
								AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
								builder.setMessage("Register Failed")
								.setNegativeButton("Retry", null)
								.create()
								.show();
								
							}
						
						} catch (JSONException e) {
							e.printStackTrace();
						}
						
						
					}
				};
			
				
				RegisterRequest registerRequest = new RegisterRequest(username, mainemail, secondaryemail, mainphone, secondaryphone, password, responselistener);
				RequestQueue queue = Volley.newRequestQueue(SignUp.this);
				queue.add(registerRequest);
				}
			}
		});
	}

	
}
