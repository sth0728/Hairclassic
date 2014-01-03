package com.example.hairclassic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class staff extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.staff);
		ImageView img1 = (ImageView) findViewById(R.id.staff1);
		img1.setScaleType(ScaleType.FIT_XY);
		
		ImageView img2 = (ImageView) findViewById(R.id.staff2);
		img2.setScaleType(ScaleType.FIT_XY);
	}

}
