package com.example.techters;

import java.util.ArrayList;
import java.util.List;

import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PagerListActivity extends Activity {

	private ListView listView;
	private Activity pri;
	List<String[]> titleList =new ArrayList<String[]>();
	//图片的文字标题 
	  private String[]  titles=new String[]
			  {
			  "时间:8:00-9:30", "课程", "地点：教学楼1202", "班级：移动开发",
			  };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager_list);
		
		initData();
		
		listView =(ListView)findViewById(R.id.listView1);
		Adapter adapter= new Adapter(titleList ,this);	
		listView.setAdapter(adapter);
	}

	//初始化
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pager_list, menu);
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
