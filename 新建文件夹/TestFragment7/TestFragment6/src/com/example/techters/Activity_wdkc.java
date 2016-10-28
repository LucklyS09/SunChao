package com.example.techters;

import java.util.ArrayList;
import java.util.List;

import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
/*	@descript 实现滑动切换图片
 *  @Date 2014-8-4
 *  @come：http://www.cnblogs.com/tinyphp/p/3890769.html
 */
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/*
 * 我的课程
 */

public class Activity_wdkc extends Activity {
	
	   private TextView tv;
	   private ListView listView,listView2,listView3;
	   private LinearLayout ddv;
	   private LinearLayout ttv;
	   
	   private  static final int PAGER_NUM=2;
		  ViewPager mviewpager;
	
	Button btu;
	ImageView imge;
	//数据源1   
		List<String[]> titleList =new ArrayList<String[]>();
		//数据源2
		List<String[]>titleList2=new ArrayList<String[]>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wdkc);
		
		//显示初始化数据源1
		initData();
		//显示初始化数据源2
		initData2();
//		显示每个listview
		initPagerview(this);
		 
		 
		
		 
		
		
		imge=(ImageView)findViewById(R.id.touxiang1);
		imge.setOnClickListener(new OnClickListener()

        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent=new Intent(Activity_wdkc.this,Activity_setting.class);
					startActivity(intent);
//					MainActivitysjj.this.finish();
			}
        	
        });
		
		//两个按钮
		 ddv=(LinearLayout)findViewById(R.id.ddv);
	        ddv.setOnClickListener(new OnClickListener()

	        {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Intent intent=new Intent(Activity_wdkc.this,Activityxspj.class);
						startActivity(intent);
//						MainActivitysjj.this.finish();
				}
	        	
	        });
	        ttv=(LinearLayout)findViewById(R.id.ttv);
			ttv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					  Intent intent=new Intent(Activity_wdkc.this,Activity_kcb.class);
						startActivity(intent);
				}
			});
		
		
	}
	//初始化数据源1
		private void initData()
		{
			String[]  titles=new String[]{"时间:8:00-9:30", "课程：Android开发", "地点：教学楼1202", "班级：移动开发"};
			titleList.add(titles);
			titles=new String[]{"时间:9:40-11:30", "课程：Android开发", "地点：教学楼1202", "班级：移动开发"};
			titleList.add(titles);
			titles=new String[]{ "时间:1:00-2:30", "课程：Android开发2", "地点：教学楼1233", "班级：移动开发"}; 
			titleList.add(titles);
			titles=new String[]{ "时间:3:00-4:30", "课程：Android开发2", "地点：教学楼1233", "班级：移动开发"}; 
			titleList.add(titles);
			
		}
		
		
		//初始化数据源2
			private void initData2()
			{
				String[]  titles2=new String[]{"时间:8:00-9:30", "课程：Android开发", "地点：教学楼1202", "班级：移动开发"};
				titleList2.add(titles2);
				titles2=new String[]{"时间:9:40-11:30", "课程：Android开发", "地点：教学楼1202", "班级：移动开发"};
				titleList2.add(titles2);
				titles2=new String[]{ "时间:1:00-2:30", "课程：Android开发2", "地点：教学楼1233", "班级：移动开发"}; 
				titleList2.add(titles2);
			}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	/**
	 * 添加课节
	 * @param context
	 */
	
	private void initPagerview(Context context){
		
		mviewpager=(ViewPager)findViewById(R.id.Viewpager);
		
		LayoutInflater lf=getLayoutInflater().from(context);
		View view1=lf.inflate(R.layout.activity_pager_list, null);
		listView =(ListView)view1.findViewById(R.id.listView1);
		listView.setOnItemClickListener(new OnItemClickListener() 
	      { 
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					Intent intent=new Intent(Activity_wdkc.this,Activityxscq.class);
					startActivity(intent);
					Activity_wdkc.this.finish();
					
				} 
	      });
		Adapter adapter= new Adapter(titleList ,this);	
		listView.setAdapter(adapter);
		
		
		View view2=lf.inflate(R.layout.pager2, null);
		listView2 =(ListView)view2.findViewById(R.id.listView2);
		listView2.setOnItemClickListener(new OnItemClickListener() 
	      { 
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					Intent intent=new Intent(Activity_wdkc.this,Activityxscq.class);
					startActivity(intent);
					Activity_wdkc.this.finish();
					
				} 
	      });
		adapter= new Adapter(titleList ,this);	
		listView2.setAdapter(adapter);
		
		View view3=lf.inflate(R.layout.pager3, null);
		listView3 =(ListView)view3.findViewById(R.id.listView3);
		listView3.setOnItemClickListener(new OnItemClickListener() 
	      { 
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					Intent intent=new Intent(Activity_wdkc.this,Activityxscq.class);
					startActivity(intent);
					Activity_wdkc.this.finish();
					
				} 
	      });
		adapter=new Adapter(titleList2,this);
		listView3.setAdapter(adapter);

		List<View> listview=new ArrayList<View>();
		
		listview.add(view1);
		listview.add(view2);
		listview.add(view3);

		//viewpager里面显示listview
		MypageAdater mpadapter=new MypageAdater(listview);
		mviewpager.setAdapter(mpadapter);
		mviewpager.setOffscreenPageLimit(PAGER_NUM);
		
		
	}
      }
	

