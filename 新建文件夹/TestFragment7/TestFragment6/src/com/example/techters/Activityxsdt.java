package com.example.techters;

import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/*
 * Ñ§Éú´ðÌâ
 * 
 */

public class Activityxsdt extends Activity {

	private GridView gridView;
	// Í¼Æ¬µÄÎÄ×Ö±êÌâ
	private String[] titles = new String[] { "Ëï³¬", "½ð¹â½Ü", "Ëï¼Ì½Ü", "°×Ç¬Â¡", "±ÏÊé¾ê", "´Ô´³Ò»", "ÀÉ×³", "ÐíÏéÀÚ", "½¯±õ"  };
	// Í¼Æ¬IDÊý×é
	private int[] images = new int[] { R.drawable.rw9, R.drawable.rw8, R.drawable.rw7,
			R.drawable.rw6, R.drawable.rw5, R.drawable.rw4, R.drawable.rw3,
			R.drawable.rw2, R.drawable.rw1 };
	
	private ImageView btnback2;
	private LinearLayout xuespjlayout1;
	private LinearLayout classlayout1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xsdt);
		
		gridView = (GridView) findViewById(R.id.gridView1);
		
		PictureAdapter adapter = new PictureAdapter(titles, images, this);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				 
				Toast.makeText(Activityxsdt.this, titles[position], Toast.LENGTH_SHORT).show();
			}
		});
		
		btnback2=(ImageView)findViewById(R.id.back2);
		btnback2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxsdt.this, Activityxscq.class);
		        startActivity(intent);
				Activityxsdt.this.finish();
				
			}
		});
		
		xuespjlayout1=(LinearLayout)findViewById(R.id.xuespjlayout2);
		xuespjlayout1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxsdt.this, Activityxspj.class);
		        startActivity(intent);
		      
				
			}
		});
		
		classlayout1=(LinearLayout)findViewById(R.id.classlayout2);
		classlayout1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxsdt.this, Activity_wdkc.class);
		        startActivity(intent);
		        Activityxsdt.this.finish();
				
			}
		});
		
	}

	
}
