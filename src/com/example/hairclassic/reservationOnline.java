package com.example.hairclassic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class reservationOnline extends Activity {
	HttpClient httpclient;
	HttpPost httppost;
	HttpResponse response;
	List<NameValuePair> nameValuePairs;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.reservationonline);
	    
	    Intent thisIntent = getIntent();
	    final String retrivedType = thisIntent.getStringExtra("type");
	    
	    // TODO Auto-generated method stub
	    ListView list = (ListView)findViewById(R.id.listView1);
	    // 1.data 제작         
        ArrayList<String> str = new ArrayList<String>();
        String holidays = getHoliday(retrivedType);
        
        for (String retval: holidays.split("<br>")){
            str.add(retval);
         }
        
        // 2.Adapter 구성
        final CustomListAdapter adapter = new CustomListAdapter(this,R.layout.listview, str);    
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				String clicked = (String)adapter.getItem(position);
				Intent intent = new Intent(getApplicationContext(), reservationDate.class);
				intent.putExtra("date", clicked);
				intent.putExtra("type", retrivedType);
				startActivity(intent);
			}
        });
	}
	
	@SuppressLint("NewApi")
	public String getHoliday(String type){
	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
	    try{
	    	httpclient = new DefaultHttpClient();
	    	httppost = new HttpPost("http://192.168.3.100/hairClassic_php/getReservationDates.php");
	    	
	        nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("type",type));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	    	response = httpclient.execute(httppost);
	    	ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    	String response = httpclient.execute(httppost, responseHandler);
	    	return response;
	    } catch(Exception E){
	    	return "";
	    }
	}
	
	public String getMonth(int monthInt){
		switch(monthInt){
		case 0:
			return "January";
		case 1:
			return "February";
		case 2:
			return "March";
		case 3:
			return "April";
		case 4:
			return "May";
		case 5:
			return "June";
		case 6:
			return "July";
		case 7:
			return "August";
		case 8:
			return "September";
		case 9:
			return "October";
		case 10:
			return "November";
		case 11:
			return "December";
		}
		return null;
	}
	
	public String getDayOfWeek(int dayInt){
		switch(dayInt){
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		}
		return null;
	}
	
	static class CustomListAdapter extends ArrayAdapter {

	    private Context mContext;
	    private int id;
	    private List <String>items ;

	    public CustomListAdapter(Context context, int textViewResourceId , List<String> list ) 
	    {
	        super(context, textViewResourceId, list);           
	        mContext = context;
	        id = textViewResourceId;
	        items = list ;
	    }

	    @Override
	    public View getView(int position, View v, ViewGroup parent)
	    {
	        View mView = v ;
	        if(mView == null){
	            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            mView = vi.inflate(id, null);
	        }

	        TextView text = (TextView) mView.findViewById(R.id.textView);

	        if(items.get(position) != null )
	        {
	            text.setTextColor(Color.WHITE);
	            text.setText(items.get(position));
	            text.setTextSize(15);
	            text.setBackgroundColor(Color.RED); 
	            int color = Color.argb( 200, 255, 64, 64 );
	                text.setBackgroundColor( color );
	        }

	        return mView;
	    }

	}
}
