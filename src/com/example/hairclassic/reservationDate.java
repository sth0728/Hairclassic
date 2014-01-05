package com.example.hairclassic;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.hairclassic.reservationOnline.CustomListAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class reservationDate extends Activity {
	List<NameValuePair> nameValuePairs;
	HttpPost httppost;
	HttpClient httpclient;
	HttpResponse response;
	
	/** Called when the activity is first created. */
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.reservationdate);
	    
	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
    	httpclient = new DefaultHttpClient();
    	httppost = new HttpPost("http://192.168.3.100/hairClassic_php/getReservationHours.php");
    	
	    // TODO Auto-generated method stub
	    Intent thisIntent = getIntent();
	    String retrivedDate = thisIntent.getStringExtra("date");
	    final String retrivedType = thisIntent.getStringExtra("type");
	    
	    ListView list = (ListView)findViewById(R.id.listViewHour);
	    ArrayList<String> str = new ArrayList<String>();
	    
	    final String[] splitedDate = retrivedDate.split(" ");
        
        nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("year",splitedDate[0]));
        nameValuePairs.add(new BasicNameValuePair("month",splitedDate[1]));
        nameValuePairs.add(new BasicNameValuePair("day",splitedDate[2]));
        nameValuePairs.add(new BasicNameValuePair("type",retrivedType));
        try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			final String response = httpclient.execute(httppost,responseHandler);
	        for (String retval: response.split("<br>")){
	            str.add(retval);
	         }
		} catch (UnsupportedEncodingException e) {
			// do nothing
		} catch (ClientProtocolException e) {
			// do nothing
		} catch (IOException e) {
			// do nothing
		}
        
	    
        final CustomListAdapter adapter = new CustomListAdapter(this,R.layout.listview, str);    
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				String clicked = (String)adapter.getItem(position);
				Intent intent = new Intent(getApplicationContext(), reservationProfile.class);
				intent.putExtra("year", splitedDate[0]);
				intent.putExtra("month", splitedDate[1]);
				intent.putExtra("day", splitedDate[2]);
				intent.putExtra("hour", clicked);
				intent.putExtra("type", retrivedType);
				startActivity(intent);
			}
        });
	}

}
