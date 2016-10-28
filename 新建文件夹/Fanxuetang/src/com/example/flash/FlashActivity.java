package com.example.flash;

import com.example.c_chengji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class FlashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash);
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash);
		
		//����Handler����
		Handler handler=new Handler();
		handler.postDelayed(new Runnable(){

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				//Intent ������ͼ����
				//����������ui��ת����ui
				Intent intent=new Intent(FlashActivity.this,LoginActivity.class);
				//������ת
				startActivity(intent);
				//��������
				FlashActivity.this.finish();
			}
			
		}, 1000);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flash, menu);
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
}
