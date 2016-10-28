package com.example.is;

import com.example.c_chengji.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class List extends FragmentActivity{

	private ListView list;
		@Override
		protected void onCreate(Bundle arg0) {
			// TODO Auto-generated method stub
			super.onCreate(arg0);
			setContentView(R.layout.main);
	    	list =  (ListView) findViewById(R.id.listView1);// 获取该id
//			list.setOnItemClickListener(new OnItemClickListener() {//监听内部类
//				public void onItemClick(AdapterView<?> parent, View v,
//						int position, long id) {
//					Intent intent=new Intent(MainActivity.this,com.example.ketang.MainActivity3.class);
//					startActivity(intent);
//				}
//			});
//            list.setOnItemClickListener(new OnItemClickListener(){
//
//				@Override
//				public void onItemClick(AdapterView<?> parent, View view,
//						int position, long id) {
//					// TODO Auto-generated method stub
//					Intent intent=new Intent(com.example.kechengbiao.m.this,com.example.ketang.MainActivity3.class);
//					startActivity(intent);
//				}
//            	
//            });
		
		
		}
}