package com.example.hairclassic;

import android.app.Activity;
import android.os.Bundle;

public class hours extends Activity {
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.hours);
	    
	    
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		this.onCreate(null);
	}

}
