package com.example.hairclassic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reservationProfile extends Activity {

	/** Called when the activity is first created. */
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.reservationprofile);
	    // TODO Auto-generated method stub
	    
	    final EditText inputName = (EditText)findViewById(R.id.editTextName);
	    final EditText inputNumber = (EditText)findViewById(R.id.editTextNumber);
	    
		// set hours button
		Button online_button = (Button)findViewById(R.id.btnReserveProfile);
		online_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String nameTxt = inputName.getText().toString().trim();
				String numberTxt = inputNumber.getText().toString().trim();
				if (nameTxt.isEmpty() | numberTxt.isEmpty()) {
					String txtmsg = "You much fill every box.";
					Toast.makeText(reservationProfile.this, txtmsg, Toast.LENGTH_SHORT).show();
				} else if (!isInteger(numberTxt)){
					String txtmsg = "Contact number should conain numbers only." + numberTxt;
					Toast.makeText(reservationProfile.this, txtmsg, Toast.LENGTH_SHORT).show();
				} else {
					//to be edited
					//send: year, month, day, hour, number, name, type
					//these to server and update the database
					//
					//then back to start
					String txtmsg = "Reservation Completed";
					Toast.makeText(reservationProfile.this, txtmsg, Toast.LENGTH_SHORT).show();
					
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
			}
		});
	}
	public static boolean isInteger(String s) {
	    return isInteger(s,10);
	}
	
	@SuppressLint("NewApi")
	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
}
