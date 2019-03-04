package com.ogh.module.mine.presenter;

import com.ogh.module.common.api.API;
import com.ogh.module.mine.view.activity.RefreshRequestActivity;
import com.ogh.module.mine.bean.PersonalizedSignatureBean;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.BasePresenter;

public class RefreshRequestPt extends BasePresenter<RefreshRequestActivity> {
    public RefreshRequestPt(RefreshRequestActivity refreshRequestActivity) {
        super(refreshRequestActivity);
    }

    /**
     * 获取个性签名
     */
    public void getPersonalizedSignature(int page) {
        createRequestBuilder()
                .setLoadStyle(page == 1 ? BaseModel.LoadStyle.DIALOG_VIEW : BaseModel.LoadStyle.NONE)
                .setLoadMode(page == 1 ? BaseModel.LoadMode.FIRST : BaseModel.LoadMode.LOAD_MODE)
                .putParam("page", page)
                .create()
                .post(API.PERSONALIZED_SIGNATURE, PersonalizedSignatureBean.class);
    }
}
