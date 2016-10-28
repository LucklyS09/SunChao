package com.example.kechengbiao;

import java.util.ArrayList;  
import java.util.List;  

import com.example.c_chengji.R;

import com.example.is.MainActivity2;
import com.example.ketang.MainActivity3;

  
import android.content.Intent;
import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.support.v4.app.FragmentActivity;  
import android.support.v4.app.FragmentManager;  
import android.support.v4.app.FragmentPagerAdapter;  
import android.support.v4.view.ViewPager;  
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
  
public class MainActivity extends FragmentActivity {  
    private CategoryTabStrip tabs;  
    private ViewPager pager;  
    private MyPagerAdapter adapter;  
    private ListView list;
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main3);  
          
        tabs = (CategoryTabStrip) findViewById(R.id.category_strip);  
        pager = (ViewPager) findViewById(R.id.view_pager);  
        adapter = new MyPagerAdapter(getSupportFragmentManager());  
  
        pager.setAdapter(adapter);  
  
        tabs.setViewPager(pager);  
        
        
        View view=findViewById(R.id.cchengji);
        view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(MainActivity.this,MainActivity2.class);
				startActivity(intent);
			}
		});
        
        View view1=findViewById(R.id.ckecheng);
        view1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(MainActivity.this,MainActivity3.class);
				startActivity(intent);
			}
		});
        
//    	list =  (ListView) findViewById(R.id.listView1);// 获取该id
//		list.setOnItemClickListener(new OnItemClickListener() {//监听内部类
//			public void onItemClick(AdapterView<?> parent, View v,
//					int position, long id) {
//				Intent intent=new Intent(MainActivity.this,com.example.ketang.MainActivity3.class);
//				startActivity(intent);
//			}
//		});
        }

    
  
    public class MyPagerAdapter extends FragmentPagerAdapter {  
  
        private final List<String> catalogs = new ArrayList<String>();  
  
        public MyPagerAdapter(FragmentManager fm) {  
            super(fm);  
            catalogs.add(getString(R.string.category_1));   
            catalogs.add(getString(R.string.category_2));  
            catalogs.add(getString(R.string.category_3));
            catalogs.add(getString(R.string.category_4));
            catalogs.add(getString(R.string.category_5));
            catalogs.add(getString(R.string.category_6));
            catalogs.add(getString(R.string.category_7));
            
        }  
  
        @Override  
        public CharSequence getPageTitle(int position) {  
            return catalogs.get(position);  
        }  
  
        @Override  
        public int getCount() {  
            return catalogs.size();  
        }  
  
        @Override  
        public Fragment getItem(int position) {  
//        	if(position==0)
       		 return NewsFragment.newInstance(position);  
//       	else if(position==1)
//       		{
//       		   return NewsFragment2.newInstance2(position); 
//       		}
//        else{
//        	   return NewsFragment3.newInstance3(position); 
//        	}
			
        	
        } 
 	
       } 
  
    }  
  

