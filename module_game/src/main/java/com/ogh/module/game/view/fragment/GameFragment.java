package com.ogh.module.game.view.fragment;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ogh.module.common.base.fragment.BaseFragment;
import com.ogh.module.game.R;

@Route(path = "/gamemoudle/gamefragment")
public class GameFragment extends BaseFragment {

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_game;
    }


    @Override
    public void initImmersionBar() {

    }
}