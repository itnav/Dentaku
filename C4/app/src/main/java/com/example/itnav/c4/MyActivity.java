package com.example.itnav.c4;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyActivity extends Activity {
    MediaPlayer mp;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

            ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
            PagerAdapter mPagerAdapter = new MyPagerAdapter();

            mViewPager.setAdapter(mPagerAdapter);

    }

    public void intentPoker(View v){

        switch (v.getId()) {
        }
    }



    private class MyPagerAdapter extends PagerAdapter {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                int[] pages = {R.layout.page_1, R.layout.page_2, R.layout.page_3, R.layout.page_4, R.layout.page_5};

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
                return 5;
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view.equals(object);
            }
    }
}
