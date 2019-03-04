package com.ogh.module.online.presenter;

import com.ogh.module.common.api.API;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.BasePresenter;
import com.ogh.module.online.bean.CityWeatherBean;
import com.ogh.module.online.view.fragment.OnlineFragment;

public class OnlinePt extends BasePresenter<OnlineFragment> {

    public OnlinePt(OnlineFragment onlineFragment) {
        super(onlineFragment);
    }

    /**
     * 获取城市天气信息
     */
    public void getCityWeather() {
        createRequestBuilder()
                .setLoadStyle(BaseModel.LoadStyle.DIALOG)
                .create()
                .get(API.CITY_WEATHER, CityWeatherBean.class);
    }
}
