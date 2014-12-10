package com.example.itnav.fragmentpageradapter;

import android.app.Fragment;
import android.app.FragmentManager;

public class TestFragmentPagerAdapter extends Fragment {
    public TestFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            default:
                return new ItemListFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page" + (position);
    }
}
