package com.ogh.module.mine.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.TextView;

import com.ogh.module.common.base.activity.BaseSwipeActivity;
import com.ogh.module.mine.R;
import com.ogh.module.mine.R2;
import com.ogh.module.mine.bean.PersonalizedSignatureBean;
import com.ogh.module.mine.adapter.ExampleAdapter;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.mine.presenter.HeadFootExamplePt;

import butterknife.BindView;

/**
 * @describe 添加头部和脚部的示例(带下拉刷新上拉加载)
 */
public class HeadFootExampleActivity extends BaseSwipeActivity<HeadFootExamplePt, PersonalizedSignatureBean> {

    @BindView(R2.id.frame_recycleView)
    RecyclerView recycleview;
    ExampleAdapter adapter;

    @Override
    protected void onRefreshRequest() {
        mPresenter.getPersonalizedSignature(2);
    }

    @Override
    protected HeadFootExamplePt setPresenter() {
        return new HeadFootExamplePt(this);
    }

    @Override
    protected void reRequest() {
        mPresenter.getPersonalizedSignature(1);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitleBar("添加头部和脚部的示例");
        adapter = new ExampleAdapter();
        initLlManager(recycleview, 1, "#F0F2F5", 10, 0, 1, 1);
        initHeadFootView();
        recycleview.setAdapter(adapter);
    }

    /**
     * 初始化头部和脚部
     */
    private void initHeadFootView() {
        TextView head = new TextView(mContext);
        head.setText("我是头部");
        head.setTextColor(Color.parseColor("#3BC68C"));
        head.setGravity(Gravity.CENTER);
        TextView foot = new TextView(mContext);
        foot.setText("我是脚部");
        foot.setTextColor(Color.parseColor("#3BC68C"));
        foot.setGravity(Gravity.CENTER);
        adapter.addHeaderView(head);
        adapter.addFooterView(foot);
    }

    @Override
    protected void initData() {
        mPresenter.getPersonalizedSignature(1);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.layout_head_foot_example;
    }

    @Override
    public void requestSuccess(PersonalizedSignatureBean data, BaseModel.LoadMode loadMode, Object tag, int pageCount) {
        adapter.addData(data.data);
    }
}
