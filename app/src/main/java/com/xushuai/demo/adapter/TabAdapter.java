package com.xushuai.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xushuai.demo.fragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2017/9/25
 * author:徐帅(acer)
 * funcation:TabLayout的适配器
 */

public class TabAdapter extends FragmentPagerAdapter {

    private List<String> title;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment1 f1 = new Fragment1();
                return f1;
            case 1:
                Fragment1 f2 = new Fragment1();
                return f2;
            case 2:
                Fragment1 f3 = new Fragment1();
                return f3;
            case 3:
                Fragment1 f4 = new Fragment1();
                return f4;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        title = new ArrayList<>();
        title.add("最新日报");
        title.add("专栏");
        title.add("热门");
        title.add("主题日报");
        return title.get(position);
    }
}