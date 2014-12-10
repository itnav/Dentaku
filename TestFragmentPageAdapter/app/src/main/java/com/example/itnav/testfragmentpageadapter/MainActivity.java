package com.example.itnav.testfragmentpageadapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by itnav on 2014/08/12.
 */
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_pager_adapter);

        FragmentManager manager = getFragmentManager();

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        final TestFragmentPagerAdapter adapter =
                new TestFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);
    }

}

