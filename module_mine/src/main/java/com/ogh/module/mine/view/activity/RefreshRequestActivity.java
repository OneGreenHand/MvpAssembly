package com.ogh.module.mine.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.ogh.module.mine.R;
import com.ogh.module.mine.R2;
import com.ogh.module.mine.bean.PersonalizedSignatureBean;
import com.ogh.module.mine.adapter.ExampleAdapter;
import com.ogh.module.common.adapter.BaseQuickAdapter;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.BaseQuickHolder;
import com.ogh.module.common.base.activity.BaseSwipeListActivity;
import com.ogh.module.mine.presenter.RefreshRequestPt;

import butterknife.BindView;

/**
 * @describe 上拉刷新和下拉加载
 */
public class RefreshRequestActivity extends BaseSwipeListActivity<RefreshRequestPt, PersonalizedSignatureBean, PersonalizedSignatureBean.DataBean> {
    @BindView(R2.id.frame_recycleView)
    RecyclerView recycleview;

    @Override
    public BaseQuickAdapter<PersonalizedSignatureBean.DataBean, BaseQuickHolder> setAdapter() {
        return new ExampleAdapter();
    }

    @Override
    public void loadMoreListRequest(int page) {
        mPresenter.getPersonalizedSignature(page);
    }

    @Override
    protected void onRefreshRequest() {
        mPresenter.getPersonalizedSignature(1);
    }

    @Override
    protected RefreshRequestPt setPresenter() {
        return new RefreshRequestPt(this);
    }

    @Override
    protected void reRequest() {
        mPresenter.getPersonalizedSignature(1);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitleBar("下拉刷新上拉加载示例");
        initLlManager(recycleview, 1, "#F0F2F5", 10, 0, 0, 0);
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
        notifyAdapterStatus(data.data, loadMode, pageCount);
    }

}
