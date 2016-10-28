package com.example.techters;

import java.util.ArrayList;
import java.util.List;

import com.example.testbase.fragment3.R;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

/*
 * 学生评价
 * 
 */

public class Activityxspj extends Fragment {

	TabHost mtabhost;
	ViewPager mviewpager;
	private ImageView btnbackpj;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Activityxspj.this.getActivity().setContentView(R.layout.activity_xspj);

		initTabhost(this);
		initPagerview(this);
		setListener();

		btnbackpj = (ImageView) Activityxspj.this.getActivity().findViewById(R.id.pjback);
		btnbackpj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

//				Activityxspj.this.finish();

			}
		});

	}

	private void setListener() {
		mtabhost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String arg0) {
				// TODO Auto-generated method stub
				int currentIndex = mtabhost.getCurrentTab();
				mviewpager.setCurrentItem(currentIndex);
			}
		});
		mviewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageSelected(int arg0) {
				// hightLightCurrentTabhost(arg0);
				mtabhost.setCurrentTab(arg0);
				switch (arg0) {
				case 0:
					mviewpager.getChildAt(arg0);
					break;
				case 1:
					mviewpager.getChildAt(arg0);
					break;
				case 2:
					mviewpager.getChildAt(arg0);
					break;

				}
			}

		});

	}

	private void initPagerview(Context activityxspj) {
		mviewpager = (ViewPager) Activityxspj.this.getActivity().findViewById(R.id.pager);
		LayoutInflater lf = getLayoutInflater(getArguments()).from(activityxspj);
		View view1 = lf.inflate(R.layout.haop, null);

		View view2 = lf.inflate(R.layout.chap, null);
		View view3 = lf.inflate(R.layout.haopchap, null);

		List<View> listview = new ArrayList<View>();
		listview.add(view1);
		listview.add(view2);
		listview.add(view3);

		Mypageradapter mpadapter = new Mypageradapter(listview);
		mviewpager.setAdapter(mpadapter);
		mviewpager.setOffscreenPageLimit(3);
	}

	private void initTabhost(Activityxspj activityxspj) {
		mtabhost = (TabHost) Activityxspj.this.getActivity().findViewById(R.id.tabhost);
		mtabhost.setup();
		mtabhost.addTab(mtabhost.newTabSpec("A").setIndicator("查看好评").setContent(android.R.id.tabcontent));
		mtabhost.addTab(mtabhost.newTabSpec("B").setIndicator("查看差评").setContent(android.R.id.tabcontent));
		mtabhost.addTab(mtabhost.newTabSpec("C").setIndicator("查看全部").setContent(android.R.id.tabcontent));
		TabWidget tabWidget = mtabhost.getTabWidget();
		for (int i =0; i < tabWidget.getChildCount(); i++) {  
	         //修改Tabhost高度和宽度
	         tabWidget.getChildAt(i).getLayoutParams().height = 130;  
	        // tabWidget.getChildAt(i).getLayoutParams().width = 65;
	         //修改显示字体大小
	         TextView tv = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);
	         tv.setTextSize(20);
	         tv.setTextColor(this.getResources().getColorStateList(android.R.color.holo_blue_bright));
//	         RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams(); 
//
//	         params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0); //取消文字底边对齐 
//	         params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE); //设置文字居中对齐 
	          
	         }
	}

}
