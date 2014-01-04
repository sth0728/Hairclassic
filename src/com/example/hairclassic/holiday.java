package com.example.hairclassic;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class holiday extends Activity {
	HttpClient httpclient;
	HttpPost httppost;
	HttpResponse response;
	/** Called when the activity is first created. */
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.holiday);
	    // TODO Auto-generated method stub
	    
	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
	    TextView tv = (TextView) findViewById(R.id.txtHolidays);
	    
	    try{
	    	httpclient = new DefaultHttpClient();
	    	httppost = new HttpPost("http://192.168.3.100/hairClassic_php/holidays.php");
	    	
	    	response = httpclient.execute(httppost);
	    	ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    	final String response = httpclient.execute(httppost, responseHandler);
	    	tv.setText(response);
	    } catch(Exception E){
	    	tv.setText("Connection Problem.");
	    }
	}

}
