package com.ogh.module.mine.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ogh.module.common.base.fragment.BaseFragment;
import com.ogh.module.common.util.IntentUtil;
import com.ogh.module.mine.R;
import com.ogh.module.mine.R2;
import com.ogh.module.mine.view.activity.HeadFootExampleActivity;
import com.ogh.module.mine.view.activity.NoDataExampleActivity;
import com.ogh.module.mine.view.activity.RefreshRequestActivity;

import butterknife.OnClick;

@Route(path = "/minemoudle/minefragment")
public class MineFragment extends BaseFragment {

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_mine;
    }


    @OnClick({ R2.id.example_one, R2.id.example_two, R2.id.example_three})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id==R.id.example_one){
            IntentUtil.goActivity(mActivity, NoDataExampleActivity.class, null, false, true);
        }else if(id==R.id.example_two){
            IntentUtil.goActivity(mActivity, HeadFootExampleActivity.class, null, false, true);
        }else if(id==R.id.example_three){
            IntentUtil.goActivity(mActivity, RefreshRequestActivity.class, null, false, true);
        }
    }
}