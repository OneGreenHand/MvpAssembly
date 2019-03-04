package com.ogh.module.common.base;

import com.ogh.module.common.bean.BaseBean;

public interface BaseRequestView<B extends BaseBean> extends BaseView {
    void requestSuccess(B data, BaseModel.LoadMode loadMode, Object tag, int pageCount);

    void requestFail(B data, Object tag);

    void requestError(Throwable e, Object tag);

    void showLoadingView();

    void showEmptyView();

    void showNetErrorView();

    void showServerErrorView(String tips);

    void refreshView();

    void tokenOverdue();
}
