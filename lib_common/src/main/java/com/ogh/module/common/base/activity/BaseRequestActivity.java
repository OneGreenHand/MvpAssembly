package com.ogh.module.common.base.activity;

import android.view.View;

import com.ogh.module.common.R;
import com.ogh.module.common.base.BasePresenter;
import com.ogh.module.common.base.BaseRequestView;
import com.ogh.module.common.bean.BaseBean;
import com.ogh.module.common.loadingView.VaryViewHelperController;
import com.ogh.module.common.util.LogUtil;
import com.ogh.module.common.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * @dessribe 带网络请求的界面
 */
public abstract class BaseRequestActivity<P extends BasePresenter, B extends BaseBean> extends BaseActivity implements BaseRequestView<B> {

    protected P mPresenter;
    private VaryViewHelperController mVaryViewHelperController;

    @Override
    protected void initCommon() {
        super.initCommon();
        View frameRootView = findViewById(R.id.frame_root_view);
        if (frameRootView != null)
            mVaryViewHelperController = new VaryViewHelperController(frameRootView, getEmptyView());
        mPresenter = setPresenter();
    }

    protected abstract P setPresenter();

    @Override
    public void requestFail(B data, Object tag) {
        ToastUtil.showCenterToast(this, data.msg);
    }

    //重新请求数据
    protected abstract void reRequest();

    @Override
    public void requestError(Throwable e, Object tag) {
        //网络请求错误
        LogUtil.e("net_error", e.getMessage());
    }

    @Override
    public void showLoadingView() {
        if (mVaryViewHelperController != null) {
            mVaryViewHelperController.showLoading();
        }
    }

    @Override
    public void showEmptyView() {
        if (mVaryViewHelperController != null) {
            //设置空数据提示文本
            Object emptyViewMsg = getEmptyViewMsg();
            if (emptyViewMsg != null && emptyViewMsg instanceof String)
                mVaryViewHelperController.showEmpty((String) emptyViewMsg);
            else if (emptyViewMsg != null && emptyViewMsg instanceof Integer)
                mVaryViewHelperController.showEmpty(getResString((Integer) emptyViewMsg));
            else
                mVaryViewHelperController.showEmpty(getResString(R.string.frame_no_data));
        }
    }


    @Override
    public void showNetErrorView() {
        if (mVaryViewHelperController != null)
            mVaryViewHelperController.showNetworkError(view -> reRequest());
    }

    @Override
    public void showServerErrorView(String tips) {
        if (mVaryViewHelperController != null)
            mVaryViewHelperController.showNetworkError(view -> reRequest(), tips);
    }

    @Override
    public void refreshView() {
        if (mVaryViewHelperController != null) {
            mVaryViewHelperController.restore();
        }
    }

    @Override
    public void tokenOverdue() {
        //登录过期，清除用户重新登录
    }
    //设置空数据提示文本
    public Object getEmptyViewMsg() {
        return null;
    }

    //设置空数据布局背景颜色
    public int getEmptyViewBg() {
        return R.color.frame_transparent;
    }

    //重写更换空数据布局
    public int getEmptyView() {
        return -1;
    }
}
