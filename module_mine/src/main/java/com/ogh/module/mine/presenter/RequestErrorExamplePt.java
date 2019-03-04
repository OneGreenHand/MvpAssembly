package com.ogh.module.mine.presenter;

import com.ogh.module.common.api.API;
import com.ogh.module.mine.view.activity.NoDataExampleActivity;
import com.ogh.module.mine.bean.PersonalizedSignatureBean;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.BasePresenter;

public class RequestErrorExamplePt extends BasePresenter<NoDataExampleActivity> {
    public RequestErrorExamplePt(NoDataExampleActivity requestErrorExampleActivity) {
        super(requestErrorExampleActivity);
    }

    /**
     * 获取个性签名
     */
    public  void getPersonalizedSignature( ){
        createRequestBuilder()
                .setLoadStyle(BaseModel.LoadStyle.DIALOG_VIEW)
                .create()
                .get(API.PERSONALIZED_SIGNATURE_ERROR,PersonalizedSignatureBean.class);
    }
}
