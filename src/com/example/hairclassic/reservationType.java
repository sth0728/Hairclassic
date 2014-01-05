package com.example.hairclassic;

import java.util.ArrayList;

import com.example.hairclassic.reservationOnline.CustomListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class reservationType extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.reservationtype);
	    // TODO Auto-generated method stub
	    ListView list = (ListView)findViewById(R.id.listViewReservationType);
	    ArrayList<String> str = new ArrayList<String>();
	    str.add("Cut");
	    str.add("Perm");
	    str.add("Color");
        final CustomListAdapter adapter = new CustomListAdapter(this,R.layout.listview, str);    
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				String clicked = (String)adapter.getItem(position);
				clicked = clicked.toLowerCase();
				Intent intent = new Intent(getApplicationContext(), reservationOnline.class);
				intent.putExtra("type", clicked);
				startActivity(intent);
			}
        });
	}

}
