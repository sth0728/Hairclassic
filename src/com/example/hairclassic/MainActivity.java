package com.example.hairclassic;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static TextView isOpenTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		isOpenTxt = (TextView)findViewById(R.id.isopen);
		
		Button button = (Button)findViewById(R.id.hours);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), hours.class);
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
	
	public void updateStatus(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		
		if (day == 1){ // case Sunday
			isOpenTxt.setText("Status: Closed");
		} else if (hour >= 20 || hour < 11){
			isOpenTxt.setText("Status: Closed");
		} else {
			isOpenTxt.setText("Status: Open (11am-8pm)");
		}
	}
}


