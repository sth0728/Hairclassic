package com.example.hairclassic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reservation extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.reservation);
	    // TODO Auto-generated method stub
	    
		// set phone button
		Button phone_button = (Button)findViewById(R.id.btnReservePhone);
		phone_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Uri number = Uri.parse("tel:+14165390515"); //
				Intent dial = new Intent(Intent.ACTION_DIAL,number);
				startActivity(dial);
			}
		});
		
		// set hours button
		Button online_button = (Button)findViewById(R.id.btnReserveOnline);
		online_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), reservationType.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		this.onCreate(null);
	}

}
