package com.xushuai.demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.xushuai.demo.adapter.TabAdapter;
import com.xushuai.demo.fragment.Fragment1;
import com.xushuai.demo.fragment.Fragment2;
import com.xushuai.demo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

import static com.xushuai.demo.R.id.tabLayout;
import static com.xushuai.demo.R.id.viewPager;

public class MainActivity extends FragmentActivity {

    private MainActivity mContext;
    private ViewPager mVp;
    private TabLayout mTabLayout;
    private List<Fragment> mFragment = new ArrayList<>();
    private TabAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mVp = (ViewPager) findViewById(viewPager);
        mTabLayout = (TabLayout) findViewById(tabLayout);
        initTabLayout();
    }

    private void initTabLayout() {
        mFragment.clear();
        mTabLayout.removeAllTabs();
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式

        //添加Fragment
        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
        mFragment.add(new Fragment3());

        //添加适配器
        mAdapter = new TabAdapter(getSupportFragmentManager(), mFragment, mContext);
        mVp.setAdapter(mAdapter);
        mVp.setOffscreenPageLimit(2);

        //绑定ViewPager
        mTabLayout.setupWithViewPager(mVp);
        mVp.setCurrentItem(0);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {
                View v = mAdapter.getView(i);
                if (i == 0) {//默认第一个选中
                    v.setSelected(true);
                }
                tab.setCustomView(v);
            }
        }

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}