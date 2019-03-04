package com.ogh.module.mine.presenter;

import com.ogh.module.common.api.API;
import com.ogh.module.mine.view.activity.HeadFootExampleActivity;
import com.ogh.module.mine.bean.PersonalizedSignatureBean;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.BasePresenter;

public class HeadFootExamplePt extends BasePresenter<HeadFootExampleActivity> {
    public HeadFootExamplePt(HeadFootExampleActivity headFootExampleActivity) {
        super(headFootExampleActivity);
    }

    /**
     * 获取个性签名
     */
    public  void getPersonalizedSignature(int page){
        createRequestBuilder()
                .setLoadStyle(BaseModel.LoadStyle.DIALOG)
                .putParam("page",page)
                .create()
                .post(API.PERSONALIZED_SIGNATURE,PersonalizedSignatureBean.class);
    }
}
