package com.example.ketang;
import java.util.ArrayList;

import com.example.c_chengji.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;


public class PagerAdapter extends FragmentPagerAdapter implements OnPageChangeListener, OnClickListener {
	private ArrayList<Fragment> fragmentsList;
	private ViewPager viewPager;
	private LinearLayout llTab;

	public PagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ViewPager viewPager, LinearLayout llTab) {
		super(fm);
		this.fragmentsList = fragments;
		this.viewPager = viewPager;
		this.llTab = llTab;

		this.viewPager.setOnPageChangeListener(this);
		
		for (int i = 0; i < llTab.getChildCount(); i++) {
			llTab.getChildAt(i).setOnClickListener(this);
		}
	}

	@Override
	public Fragment getItem(int position) {

		// Fragment fragment = new DummySectionFragment();
		// Bundle args = new Bundle();
		// args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position +
		// 1);
		// fragment.setArguments(args);

		return fragmentsList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentsList.size();
	}

	// ******************OnPageChangeListener***************
	@Override
	public void onPageScrollStateChanged(int state) {
		System.out.println("onPageScrollStateChanged:" + state);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		System.out.println("onPageScrolled:" + position + ">>" + positionOffset + ">>" + positionOffsetPixels);
	}

	@Override
	public void onPageSelected(int position) {
		System.out.println("onPageSelected:" + position);
		for (int i = 0; i < llTab.getChildCount(); i++) {
			if (position == i) {
				llTab.getChildAt(i).setBackgroundResource(R.drawable.bg_view_pager_scroll_selected);
			} else {
				llTab.getChildAt(i).setBackgroundResource(R.drawable.bg_view_pager_scroll_unselect);
			}
		}
	}

	// ******************OnPageChangeListener***************

	@Override
	public void onClick(View view) {
		for (int i = 0; i < llTab.getChildCount(); i++) {
			if (view.equals(llTab.getChildAt(i))) {
				llTab.getChildAt(i).setBackgroundResource(R.drawable.bg_view_pager_scroll_selected);
				viewPager.setCurrentItem(i);
			} else {
				llTab.getChildAt(i).setBackgroundResource(R.drawable.bg_view_pager_scroll_unselect);
			}
		}
		
	}
}