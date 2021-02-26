package com.frn.contactivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Home extends  Activity {

	ListView listView;
	ArrayAdapter<String> listAdapter;
	String fragmentArray[] = {"Program Mail","Program SMS"};
	DrawerLayout drawerLayout;
	public static String Username = new String();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		listView = (ListView) findViewById(R.id.ListView1);
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fragmentArray);
		listView.setAdapter(listAdapter);
		drawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
		Bundle bundle = getIntent().getExtras();
	    Username =bundle.getString("username");
		
	    
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@SuppressLint("CommitTransaction")
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Fragment fragment;
				
				switch(position){
				case 0:
					fragment = new FragmentOne();
					break;
				case 1:
					fragment = new FragmentTwo();
					break;
				case 2:
				    
					default:
						fragment = new FragmentOne();
						break;
					
					
				}
				FragmentManager fragmentManager = getFragmentManager();
				 fragmentManager.beginTransaction().replace(R.id.relativelayout1, fragment).commit();
				drawerLayout.closeDrawers();
				
				
			
				
			}
			
			
		});
		
		
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_home, menu);
	    return true;
	}
	
	
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.action_my_contacts:
            	Intent homeIntent = new Intent (Home.this , Information.class);
            	homeIntent.putExtra("username", Username);
                Home.this. startActivity(homeIntent);
                return true;
        }

        return true;
    }

 
    
		
}
