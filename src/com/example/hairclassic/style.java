package com.example.hairclassic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class style extends Activity {
	ImageView selectedImage;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.styles);
	    
	    final Gallery gallery = (Gallery) findViewById(R.id.gallery1);
	    gallery.setAdapter(new ImageAdapter(this));
	    
	    gallery.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int position, long id) {
				TextView tv = (TextView) findViewById(R.id.my_text);
				tv.setText("Position = " + position);
				//ImageView iv = (ImageView) findViewById(R.id.imageView1);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	}
	
	public class ImageAdapter extends BaseAdapter{
		private Context m_context;
		private int background;
		
		private int[] m_image_id={
				R.drawable.g00,
				R.drawable.g01,
				R.drawable.g02,
				R.drawable.g03,
				R.drawable.g04,
				R.drawable.g05,
				R.drawable.g06,
				R.drawable.g07,
				R.drawable.g08,
				R.drawable.g09,
				R.drawable.g10,
				R.drawable.g11,
				R.drawable.g12,
				R.drawable.g13,
				R.drawable.g14,
				R.drawable.g15,
				R.drawable.g16,
				R.drawable.g17,
				R.drawable.g18,
				R.drawable.g19};
		
		public ImageAdapter(Context c){
			m_context = c;
			TypedArray a = c.obtainStyledAttributes(R.styleable.Theme);
			background = a.getResourceId(R.styleable.Theme_android_galleryItemBackground, 0);
		}
		
		public int getCount(){
			return m_image_id.length;
		}
		
		
		public long getItemId(int position){
			return position;
		}
		
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@SuppressLint("NewApi")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Display display = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			int width = (int) Math.round(size.x * 0.8);
			int height = (int) Math.round(size.y * 0.7);
			
			ImageView iv = new ImageView(m_context);
			
			iv.setImageResource(m_image_id[position]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setBackgroundResource(background);
			iv.setLayoutParams(new Gallery.LayoutParams(width,height));
			return iv;
		}
	}

}

