package com.example.techters;
/**
 * Ò³Ãæ×ª»»
 */
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MypageAdater extends PagerAdapter {

	List<View> mviewlist;
	
	
	public MypageAdater(List<View> viewlist) {
		
		mviewlist = viewlist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mviewlist.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(mviewlist.get(position));
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mviewlist.get(position));
		return mviewlist.get(position);
	}

	public List<View> getViewlist(){
		return mviewlist;
	}

}
