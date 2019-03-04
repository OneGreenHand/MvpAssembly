package com.ogh.module.mine.adapter;

import com.ogh.module.mine.R;
import com.ogh.module.mine.bean.PersonalizedSignatureBean;
import com.ogh.module.common.adapter.BaseQuickAdapter;
import com.ogh.module.common.base.BaseQuickHolder;

public class ExampleAdapter extends BaseQuickAdapter<PersonalizedSignatureBean.DataBean, BaseQuickHolder> {

    public ExampleAdapter() {
        super(R.layout.item_common);
    }

    @Override
    protected void convert(BaseQuickHolder helper, PersonalizedSignatureBean.DataBean item) {
        helper.setText(R.id.item_title, item.femalename);
    }
}
