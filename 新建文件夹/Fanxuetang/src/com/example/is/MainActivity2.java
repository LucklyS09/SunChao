package com.example.is;

import java.util.ArrayList;  
import java.util.List;  

import com.example.c_chengji.R;

  
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.support.v4.app.FragmentActivity;  
import android.support.v4.app.FragmentManager;  
import android.support.v4.app.FragmentPagerAdapter;  
import android.support.v4.view.ViewPager;  
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
  
public class MainActivity2 extends FragmentActivity {  
    private CategoryTabStrip tabs;  
    private ViewPager pager;  
    private MyPagerAdapter adapter;  
  private Button im;
    protected void onCreate( Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        
        List<Fragment> fragments = new ArrayList<Fragment>();  
        fragments.add(new NewsFragment());  
        fragments.add(new NewsFragment2());
          
        tabs = (CategoryTabStrip) findViewById(R.id.category_strip);  
        pager = (ViewPager) findViewById(R.id.view_pager);  
        adapter = new MyPagerAdapter(getSupportFragmentManager());  
  
        pager.setAdapter(adapter);  
  
        tabs.setViewPager(pager);  
        im = (Button) findViewById(R.id.button1);
        im.setOnClickListener(new View.OnClickListener(){ 
  	      @Override 
  	      public void onClick(View v){
  	          //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
  	          //page1为先前已添加的类，并已在AndroidManifest.xml内添加活动事件(<activity android:name="page1"></activity>),在存放资源代码的文件夹下下， 
  	          Intent i = new Intent(MainActivity2.this , MainActivity2.class);
  	          ////启动 
  	          startActivity(i); 
  	      } 
  	});
////        Button button = (Button)findViewById(R.id.kaoshi);
////        button.setOnClickListener(new View.OnClickListener()
//        
//        View view = inflater.inflate(R.layout.activity_main, container, false);  
//        view.findViewById(R.id.fanhui).setOnClickListener(new OnClickListener(){
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO 自动生成的方法存根
//				Intent intent=new Intent(MainActivity.this,FanhuiActivity.class);
//				startActivity(intent);
//			}
//		});
      
        
        View view1=findViewById(R.id.button1);
        view1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(MainActivity2.this,com.example.kechengbiao.MainActivity.class);
				startActivity(intent);
			}
        	
        });
    }
    
    
  
    public class MyPagerAdapter extends FragmentPagerAdapter {  
  
        private final List<String> catalogs = new ArrayList<String>();  
  
        public MyPagerAdapter(FragmentManager fm) {  
            super(fm);  
            catalogs.add(getString(R.string.category_paihangbang));   
            catalogs.add(getString(R.string.category_wodechengji));  
            /*catalogs.add(getString(R.string.category_entertainment));  
            catalogs.add(getString(R.string.category_finance));  
            catalogs.add(getString(R.string.category_military));  
            catalogs.add(getString(R.string.category_world));  
            catalogs.add(getString(R.string.category_image_ppmm));  
            catalogs.add(getString(R.string.category_government)); */ 
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
        	else
        		return NewsFragment2.newInstance2(position);
        	
           
        } 
        
       
  
    }  

} 


