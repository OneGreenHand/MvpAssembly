package com.ogh.module.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ogh.module.R;
import com.ogh.module.common.config.BaseConfig;
import com.ogh.module.common.util.ToastUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
	
    private IWXAPI api;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_result);
    	api = WXAPIFactory.createWXAPI(this, BaseConfig.WEIXIN_APP_ID);
        api.handleIntent(getIntent(), this);
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			switch (resp.errCode){
				case 0:
					ToastUtil.showCenterToast(this,"支付成功");
					finish();
					break;
				case -2:
					ToastUtil.showCenterToast(this,"支付取消");
					finish();
					break;
				default:
					ToastUtil.showCenterToast(this, "支付失败，错误码：" + resp.errCode);
					finish();
					break;
			}
		}
	}
}