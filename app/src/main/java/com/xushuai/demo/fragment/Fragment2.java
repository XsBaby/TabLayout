package com.xushuai.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xushuai.demo.R;

/**
 * date:2017/9/25
 * author:acer
 * funcation:第二个Fragment
 */

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View.inflate(getActivity(), R.layout.f2, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}