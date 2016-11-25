package com.shutaowohang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by saltwind on 2016/11/15.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<Fragment>();

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    //添加fragment到集合中
    public void addFragment(Fragment fragment){
        if(fragment!=null){
            this.fragments.add(fragment);
        }
    }

    //获得当前适配的fragment项
    @Override
    public Fragment getItem(int arg0) {
        return fragments.get(arg0);
    }
    //获得要适配的fragment总数
    @Override
    public int getCount() {
        return fragments.size();
    }
}
