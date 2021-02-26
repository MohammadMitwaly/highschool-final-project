package com.frn.contactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity  {
	
    EditText etUsername, etPassword;
	TextView SignUpLink;
	Button btLogin;
	DatabaseHelper helper = new DatabaseHelper(this);
	String [] m = new String[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		etUsername = (EditText) findViewById(R.id.etUsername);
		etPassword = (EditText) findViewById(R.id.etPassword);
		SignUpLink = (TextView) findViewById(R.id.SignUpLink);
		btLogin = (Button) findViewById(R.id.btlogin);
		
		
		SignUpLink.setOnClickListener(new View.OnClickListener() 
		
		{
			
			@Override
			public void onClick(View v) {
				Intent SignUpIntent = new Intent (Login.this , SignUp.class);
				Login.this.startActivity(SignUpIntent);
				
				
			}
		});	
		
		btLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String username = etUsername.getText().toString();
				String password = etPassword.getText().toString();
				if(username.equals("") || password.equals(""))
				{
					AlertDialog.Builder bu1lder = new AlertDialog.Builder(Login.this);
					bu1lder.setMessage("Username or Password are Missing")
					.setNegativeButton("OK", null)
					.create()
					.show();
				}
				else
				{
			
				
				String pass1 = helper.searchPassword(username);
				
				if(pass1.equals(password))
				{
			        String Username = etUsername.getText().toString();
					Intent LoginIntent = new Intent (Login.this, Home.class);
                    LoginIntent.putExtra("username", Username);
					Login.this.startActivity(LoginIntent);	
				}
				else
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
					builder.setMessage("Login Failed")
					.setNegativeButton("Retry", null)
					.create()
					.show();
				}
	
			}
		    }
		});
						
					
		
	}
	
	
		
	
}
	


