package com.ogh.module.mine.view.activity;

import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.activity.BaseSwipeActivity;
import com.ogh.module.common.bean.BaseBean;
import com.ogh.module.mine.R;
import com.ogh.module.mine.presenter.RequestErrorExamplePt;

/**
 * @describe 无数据显示示例
 */
public class NoDataExampleActivity extends BaseSwipeActivity<RequestErrorExamplePt, BaseBean> {
    @Override
    protected void onRefreshRequest() {
        ToastUtils.showShort("下拉刷新");
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected RequestErrorExamplePt setPresenter() {
        return new RequestErrorExamplePt(this);
    }

    @Override
    protected void reRequest() {
        ToastUtils.showShort("重新请求");
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitleBar("无数据显示示例");
    }

    @Override
    protected void initData() {
        mPresenter.getPersonalizedSignature();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.layout_head_foot_example;
    }

    @Override
    public void requestSuccess(BaseBean data, BaseModel.LoadMode loadMode, Object tag, int pageCount) {
        ToastUtils.showShort(data.msg);
    }
}
