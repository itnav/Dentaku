package com.example.itnav.c4;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by itnav on 2014/08/22.
 */
public class MyPagerAdapter extends PagerAdapter {




    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int[] pages = {R.layout.page_1, R.layout.page_2, R.layout.page_3};

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        View layout ;
        layout = inflater.inflate(pages[position], null);
        ((ViewPager) container).addView(layout);
        return layout;
    }




    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }






}