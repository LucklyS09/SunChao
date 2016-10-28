package com.example.techters;



import java.util.Timer;
import java.util.TimerTask;

import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
/*
 * Ñ§Éú³öÇÚ
 * 
 */
public class Activityxscq extends Activity {

	private GridView gridView;
	// Í¼Æ¬µÄÎÄ×Ö±êÌâ
	private String[] titles = new String[] { "Ëï³¬", "½ð¹â½Ü", "Ëï¼Ì½Ü", "°×Ç¬Â¡", "±ÏÊé¾ê", "´Ô´³Ò»", "ÀÇ×³", "ÐíÏéÀÚ", "½¯±õ" };
	// Í¼Æ¬IDÊý×é
	private int[] images = new int[] { R.drawable.rw1, R.drawable.rw2, R.drawable.rw3,
			R.drawable.rw4, R.drawable.rw5, R.drawable.rw6, R.drawable.rw7,
			R.drawable.rw8, R.drawable.rw9 };
	
	private Button btntiwen1;
	private LinearLayout xuespjlayout1;
	private LinearLayout classlayout1;
	ImageView btnback1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xscq);
		gridView = (GridView) findViewById(R.id.gridView1);
		
		PictureAdapter adapter = new PictureAdapter(titles, images, this);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast toast=Toast.makeText(Activityxscq.this, titles[position], Toast.LENGTH_SHORT);
				showMyToast(toast, 1000);
			}
		});
		
		btnback1=(ImageView)findViewById(R.id.back1);
		btnback1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxscq.this, Activity_wdkc.class);
		        startActivity(intent);
		        Activityxscq.this.finish();
				
			}
		});
		
		btntiwen1=(Button)findViewById(R.id.btan1);
		btntiwen1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxscq.this, Activityxsdt.class);
		        startActivity(intent);
		        Activityxscq.this.finish();
				
			}
		});
		xuespjlayout1=(LinearLayout)findViewById(R.id.xuespjlayout1);
		xuespjlayout1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxscq.this, Activityxspj.class);
		        startActivity(intent);
		        
			}
		});
		
		classlayout1=(LinearLayout)findViewById(R.id.classlayout1);
		classlayout1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Activityxscq.this, Activity_wdkc.class);
		        startActivity(intent);
		        Activityxscq.this.finish();
				
			}
		});
		
	}
	//toast
	public void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }
}

	

	

	
