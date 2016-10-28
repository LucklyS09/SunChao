package com.example.ketang;

import java.util.ArrayList;  
import java.util.List;  


import com.example.c_chengji.R;
import com.example.is.MainActivity2;
  
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.support.v4.app.FragmentActivity;  
import android.support.v4.app.FragmentManager;  
import android.support.v4.app.FragmentPagerAdapter;  
import android.support.v4.view.ViewPager;  
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
  
public class MainActivity3 extends FragmentActivity {  
    private CategoryTabStrip tabs;  
    private ViewPager pager;  
    private MyPagerAdapter adapter;
  
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main2);  
          
        List<Fragment> fragments = new ArrayList<Fragment>();  
        fragments.add(new NewsFragment());  
        fragments.add(new NewsFragment2());
          
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
				Intent intent=new Intent(MainActivity3.this,com.example.is.MainActivity2.class);
				startActivity(intent);
			}
		});
        View view2=findViewById(R.id.ckecheng);
        view2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(MainActivity3.this,com.example.kechengbiao.MainActivity.class);
				startActivity(intent);
			}
		});
        
   }
    
    
  
    public class MyPagerAdapter extends FragmentPagerAdapter {  
  
        private final List<String> catalogs = new ArrayList<String>();  
  
        public MyPagerAdapter(FragmentManager fm) {  
            super(fm);  
            catalogs.add(getString(R.string.category_qiandao));   
            catalogs.add(getString(R.string.category_wenti));  
            catalogs.add(getString(R.string.category_jiaoshi));
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
        	if(position==0)
       		 return NewsFragment.newInstance(position);  
       	else if(position==1)
       		{
       		   return NewsFragment2.newInstance2(position); 
       		}
        else{
        	   return NewsFragment3.newInstance3(position); 
        	}
			
        	
        } 
 	
       } 
  
    }  
  

