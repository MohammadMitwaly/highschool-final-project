package com.frn.contactivity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "User.db";
	private static final String TABLE_NAME = "user";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_USERNAME = "username";
	private static final String COLUMN_MAINEMAIL = "mainemail";
	private static final String COLUMN_SECONDARYEMAIL = "secondaryemail";
	private static final String COLUMN_MAINPHONE = "mainphone";
	private static final String COLUMN_SECONDARYPHONE = "secondaryphone";
	private static final String COLUMN_PASSWORD = "password";
	SQLiteDatabase db;
	private static final String TABLE_CREATE = "create table " +TABLE_NAME+ "("+COLUMN_ID+" integer primary key not null ,"+COLUMN_USERNAME+" text not null, "+COLUMN_MAINEMAIL+" text not null, "+COLUMN_SECONDARYEMAIL+" text not null, "+COLUMN_MAINPHONE+" text not null, "+COLUMN_SECONDARYPHONE+" text not null, "+COLUMN_PASSWORD+" text not null "+" );";
	
	public DatabaseHelper (Context context)
	{
	   super(context, DATABASE_NAME, null, DATABASE_VERSION);	
	}
	


	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(TABLE_CREATE);
		this.db = db;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
	String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
	db.execSQL(query);
	this.onCreate(db);
		
	}


	public boolean insertUser(User c) 
	{
		db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		String query = "select * from user";
		Cursor cursor = db.rawQuery(query, null);
		int count = cursor.getCount();
		values.put(COLUMN_ID, count);
		values.put(COLUMN_USERNAME, c.getUsername());
		values.put(COLUMN_MAINEMAIL, c.getMainEmail());
		values.put(COLUMN_SECONDARYEMAIL, c.getSecondaryEmail());
		values.put(COLUMN_MAINPHONE, c.getMainPhone());
		values.put(COLUMN_SECONDARYPHONE, c.getSecondaryPhone());
		values.put(COLUMN_PASSWORD, c.getPassword());
		db.insert(TABLE_NAME, null, values);
		return true;
		
	}
	
	public boolean updateContact(User c)
	{
		db=this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_USERNAME, c.getUsername());
		values.put(COLUMN_MAINEMAIL, c.getMainEmail());
		values.put(COLUMN_SECONDARYEMAIL, c.getSecondaryEmail());
		values.put(COLUMN_MAINPHONE, c.getMainPhone());
		values.put(COLUMN_SECONDARYPHONE,c.getSecondaryPhone());
		values.put(COLUMN_PASSWORD, c.getPassword());	
		db.update("user", values, "username = ? ", new String[]  {  c.getUsername() } );
		return true;
	}
	
	public String searchPassword(String username) 
	{
		db = this.getReadableDatabase();
		String query="select username, password from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String a;
		String b="not found";
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				a=cursor.getString(0);
				if(a.equals(username))
				{
			    b=cursor.getString(1);
				cursor.close();
				return b;
				}
				cursor.moveToNext();
			     }
		cursor.close();
		return b;
		}
		else return b;
	}
	
	public String searchMainEmail(String username) 
	{
		db = this.getReadableDatabase();
		String query="select username, mainemail from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String a;
		String b="not found";
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				a=cursor.getString(0);
				if(a.equals(username))
				{
			    b=cursor.getString(1);
				cursor.close();
				return b;
				}
				cursor.moveToNext();
			     }
		cursor.close();
		return b;
		}
		else return b;
	}
	
	public String searchSecondaryEmail(String username) 
	{
		db = this.getReadableDatabase();
		String query="select username, secondaryemail from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String a;
		String b="not found";
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				a=cursor.getString(0);
				if(a.equals(username))
				{
			    b=cursor.getString(1);
				cursor.close();
				return b;
				}
				cursor.moveToNext();
			     }
		cursor.close();
		return b;
		}
		else return b;
	}
	
	public String searchMainPhone(String username) 
	{
		db = this.getReadableDatabase();
		String query="select username, mainphone from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String a;
		String b="not found";
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				a=cursor.getString(0);
				if(a.equals(username))
				{
			    b=cursor.getString(1);
				cursor.close();
				return b;
				}
				cursor.moveToNext();
			     }
		cursor.close();
		return b;
		}
		else return b;
	}
	
	
	public String searchSecondaryPhone(String username) 
	{
		db = this.getReadableDatabase();
		String query="select username, secondaryphone from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String a;
		String b="not found";
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				a=cursor.getString(0);
				if(a.equals(username))
				{
			    b=cursor.getString(1);
				cursor.close();
				return b;
				}
				cursor.moveToNext();
			     }
		cursor.close();
		return b;
		}
		else return b;
	}
	
	
	public String[] UserInfo (String username)
	{
		db=this.getReadableDatabase();
		String query="select username, mainemail, secondaryemail, mainphone, secondaryphone, password from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String [] f = new String[5];	
		String uname="not found";
		String email1="not found";
		String email2="not found";
		String phone1="not found";
		String phone2="not found";
		String pass="not found";
		f[0]= uname;
		f[1]= email1;
		f[2]= email2;
		f[3]= phone1;
		f[4]= phone2;
		f[5]= pass;
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				uname=cursor.getString(0);
				if(uname.equals(username))
				{
			    email1=cursor.getString(1);
			    email2=cursor.getString(2);
			    phone1=cursor.getString(3);
			    phone2=cursor.getString(4);
			    pass=cursor.getString(5);
				cursor.close();
				f[0]= uname;
				f[1]= email1;
				f[2]= email2;
				f[3]= phone1;
				f[4]= phone2;
				f[5]= pass;
				return f;
				}
				cursor.moveToNext();
			}
		cursor.close();
		return f;
		}
		else return f;
	}
	
	
	public boolean UsernameAvailable(String username) 
	{
		db = this.getReadableDatabase();
		String query="select username from "+TABLE_NAME;
		Cursor cursor=db.rawQuery(query , null);
		String a;
		if(cursor.moveToFirst())
		{
			while(! cursor.isAfterLast())
			{
				a=cursor.getString(0);
				if(a.equals(username))
				{
			    
				return false;
				}
				cursor.moveToNext();
			     }
		cursor.close();
		return true;
		}
		else return true;
	}
	


}
