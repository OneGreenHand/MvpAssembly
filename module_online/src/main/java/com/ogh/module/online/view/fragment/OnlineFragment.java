package com.ogh.module.online.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ogh.module.common.base.BaseModel;
import com.ogh.module.common.base.fragment.BaseRequestFragment;
import com.ogh.module.common.bean.BaseBean;
import com.ogh.module.online.R;
import com.ogh.module.online.R2;
import com.ogh.module.online.bean.CityWeatherBean;
import com.ogh.module.online.presenter.OnlinePt;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/onlinemoudle/onlinefragment")
public class OnlineFragment extends BaseRequestFragment<OnlinePt, BaseBean> {
    @BindView(R2.id.request_msg)
    TextView requestMsg;

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_online;
    }

    @OnClick({R2.id.post_request})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id==R.id.post_request){
            mPresenter.getCityWeather();
        }
    }

    @Override
    protected OnlinePt setPresenter() {
        return new OnlinePt(this);
    }

    @Override
    protected void reRequest() {

    }


    @Override
    public void requestSuccess(BaseBean data, BaseModel.LoadMode loadMode, Object tag, int pageCount) {
        CityWeatherBean cityWeatherBean = (CityWeatherBean) data;
        requestMsg.setText("城市：" + cityWeatherBean.data.city + "\n日期：" + cityWeatherBean.data.yesterday.date + "\n最低温度：" + cityWeatherBean.data.yesterday.low + "\n最高温度：" + cityWeatherBean.data.yesterday.high);
    }
}
