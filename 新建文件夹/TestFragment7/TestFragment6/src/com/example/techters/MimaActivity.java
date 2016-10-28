package com.example.techters;



import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


/*
 * …Ë÷√√‹¬Î
 */

public class MimaActivity extends Activity implements OnClickListener{
	private ImageView switchAvatar;
	ImageView imageView=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mima);
		switchAvatar = (ImageView) findViewById(R.id.back3);
		switchAvatar.setOnClickListener(listener);
		
	}
	private View.OnClickListener listener = new View.OnClickListener() {

		public void onClick(View v) {
//			Intent intent = new Intent(MimaActivity.this, Activity_setting.class); 
//            startActivity(intent);
            MimaActivity.this.finish();
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mima, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
