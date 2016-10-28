package com.example.kechengbiao;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.c_chengji.R;

public class NewsFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	
	private ListView listview;
	
	List<String[]> titleList = new ArrayList<String[]>();

	// ͼƬ�����ֱ���
	private String[] titles = new String[] { "ʱ��:8:00-9:30", "�γ̣�Android����",
			"�ص㣺��ѧ¥1202", "�༶���ƶ�����",

	};
   private Activity pra;
	
	public static NewsFragment newInstance(int position) {
		NewsFragment f = new NewsFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}


//	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//
//		FrameLayout fl = new FrameLayout(getActivity());
//		fl.setLayoutParams(params);
//
//		final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
//				.getDisplayMetrics());
//		return fl;

//		TextView v = new TextView(getActivity());
//		params.setMargins(margin, margin, margin, margin);
//		v.setLayoutParams(params);
//		v.setLayoutParams(params);
//		v.setGravity(Gravity.CENTER);
//		v.setText("PAGE " + (position + 1));
//
//		fl.addView(v);
//		return fl;
//	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.main, container, false);  
        
        initData();
		listview = (ListView)view.findViewById(R.id.listView1);
		Adapter adapter = new Adapter(titleList, this.getActivity());
		listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(NewsFragment.this.getActivity(),com.example.ketang.MainActivity3.class);
				startActivity(intent);
				
			}
        	
        });
	
		
        return view;  
    } 
	
	private void initData() {
		String[] titles = new String[] { "ʱ��:8:00-9:30", "�γ̣�Android����",
				"�ص㣺��ѧ¥1202", "�༶���ƶ�����" };
		titleList.add(titles);
		titles = new String[] { "ʱ��:9:40-11:30", "�γ̣�Android����2",
				"�ص㣺��ѧ¥12022", "�༶���ƶ�����2" };
		titleList.add(titles);
		titles = new String[] { "ʱ��:1:00-2:30", "�γ̣�Android����2", "�ص㣺��ѧ¥1233",
				"�༶���ƶ�����" };
		titleList.add(titles);
		titles = new String[] { "ʱ��:3:00-4:30", "�γ̣�Android����2", "�ص㣺��ѧ¥1233",
				"�༶���ƶ�����" };
		titleList.add(titles);
	}


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