package com.example.itnav.c4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class MyActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        GestureDetectView view = new GestureDetectView(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(view);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter mPagerAdapter = new MyPagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);

        ImageButton imgb = (ImageButton)findViewById(R.id.imageButton);
        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, Sub.class);
                startActivity(intent);
            }
        });



    }

        private class MyPagerAdapter extends PagerAdapter {




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


}
