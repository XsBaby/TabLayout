package com.xushuai.demo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xushuai.demo.R;

import java.util.List;

/**
 * date:2017/9/25
 * author:acer
 * funcation:TabLayout的适配器
 */

public class TabAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment> mFragment;
    private String[] mName = {"首页", "联系人", "动态"};
    private int[] mRes = {R.drawable.home_bg, R.drawable.person_bg, R.drawable.userself_bg};

    public TabAdapter(FragmentManager fm, List<Fragment> fragment, Context context) {
        super(fm);
        this.mFragment = fragment;
        this.mContext = context;
    }

    public View getView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        TextView name = (TextView) v.findViewById(R.id.name);
        ImageView img = (ImageView) v.findViewById(R.id.img);
        name.setText(mName[position]);
        img.setImageResource(mRes[position]);
        return v;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mName.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mName[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}