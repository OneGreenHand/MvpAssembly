package com.ogh.module.home.view.fragment;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ogh.module.common.base.fragment.BaseFragment;
import com.ogh.module.home.R;

@Route(path = "/homemoudle/homefragment")
public class HomeFragment extends BaseFragment {

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home;
    }


    @Override
    public void initImmersionBar() {

    }
}