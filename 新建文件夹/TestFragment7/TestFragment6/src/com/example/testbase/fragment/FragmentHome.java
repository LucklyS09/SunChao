package com.example.testbase.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.a_tab2.CategoryTabStrip;
import com.example.a_tab2.NewsFragment;
import com.example.a_tab2.MainActivity.MyPagerAdapter;
import com.example.testbase.commom.T;
import com.example.testbase.fragment3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentHome extends Fragment {
	
	 private CategoryTabStrip tabs;  
	 private ViewPager pager;  
	 private MyPagerAdapter adapter;  

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_home, null);

		   
        tabs = (CategoryTabStrip) view.findViewById(R.id.category_strip);  
        pager = (ViewPager) view.findViewById(R.id.view_pager);  
        adapter = new MyPagerAdapter(this.getChildFragmentManager());  
  
        pager.setAdapter(adapter);  
  
        tabs.setViewPager(pager);  

		return view;

	}
	
	 public class MyPagerAdapter extends FragmentPagerAdapter {  
		  
	        private final List<String> catalogs = new ArrayList<String>();  
	  
	        public MyPagerAdapter(FragmentManager fm) {  
	            super(fm);  
	            catalogs.add(getString(R.string.category_hot));   
	            catalogs.add(getString(R.string.category_video));  
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
	            return NewsFragment.newInstance(position);  
	        }  
	  
	    }  
}
