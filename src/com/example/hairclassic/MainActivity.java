package com.example.hairclassic;

import java.io.InputStream;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	HttpClient httpclient;
	HttpPost httppost;
	HttpResponse response;
	
	private static TextView isOpenTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		isOpenTxt = (TextView)findViewById(R.id.isopen);
		
		// set hours button
		Button button = (Button)findViewById(R.id.hours);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), hours.class);
				startActivity(intent);
			}
		});
		
		// set styles button
		Button style_button = (Button)findViewById(R.id.styles);
		style_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), style.class);
				startActivity(intent);
			}
		});
		
		// set offer button
		Button staff_button = (Button)findViewById(R.id.staffs);
		staff_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), staff.class);
				startActivity(intent);
			}
		});
		
		// set offer button
		Button offer_button = (Button)findViewById(R.id.offer);
		offer_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), offer.class);
				startActivity(intent);
			}
		});
		
		// set hours button
		Button reservation_button = (Button)findViewById(R.id.reservation);
		reservation_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), reservation.class);
				startActivity(intent);
			}
		});
		
		// set hours button
		Button holiday_button = (Button)findViewById(R.id.holiday);
		holiday_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), holiday.class);
				startActivity(intent);
			}
		});
		
		this.updateStatus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@SuppressLint("NewApi")
	public void updateStatus(){
	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
	    TextView tv = (TextView) findViewById(R.id.isopen);
	    
	    try{
	    	httpclient = new DefaultHttpClient();
	    	httppost = new HttpPost("http://192.168.3.100/hairClassic_php/hours.php");
	    	
	    	response = httpclient.execute(httppost);
	    	ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    	final String response = httpclient.execute(httppost, responseHandler);
	    	tv.setText("Status: " + response);
	    } catch(Exception E){
	    	tv.setText("Connection Problem.");
	    }
	}
}


