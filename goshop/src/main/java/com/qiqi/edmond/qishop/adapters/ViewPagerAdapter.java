package com.qiqi.edmond.qishop.adapters;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import java.util.ArrayList;

/**
 * 
 * @author 巨蟹巨蟹
 * @email zansl@qq.com
 * 
 */
public class ViewPagerAdapter extends PagerAdapter {

	private ArrayList<View> mPageViews;

	public ViewPagerAdapter(ArrayList<View> mPageViews) {

		this.mPageViews = mPageViews;

	}

	@Override
	public int getCount() {
		return mPageViews.size();
	}

	@Override
	public boolean isViewFromObject(View v, Object arg1) {
		return v == arg1;
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}

	@Override
	public void destroyItem(View v, int p, Object arg2) {
		// TODO Auto-generated method stub
		((ViewPager) v).removeView(mPageViews.get(p));
	}

	@Override
	public Object instantiateItem(View v, int p) {
		// TODO Auto-generated method stub

		View view = mPageViews.get(p);
		((ViewPager) v).addView(view);
		return view;
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUpdate(View arg0) {

	}

	@Override
	public void finishUpdate(View arg0) {
		// TODO Auto-generated method stub

	}

}
