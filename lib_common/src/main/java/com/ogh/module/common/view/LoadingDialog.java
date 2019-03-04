package com.ogh.module.common.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.ogh.module.common.R;
import com.ogh.module.common.R2;
import com.ogh.module.common.base.BaseDialog;
import com.ogh.module.common.widget.dialog.IntertwineLoadingView;

import butterknife.BindView;


/**
 * 加载框
 */
public class LoadingDialog extends BaseDialog {
    @BindView(R2.id.loadView)
    IntertwineLoadingView loadView;
    @BindView(R2.id.loading_text)
    TextView loadingText;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle, R.style.PopWindowAnimStyle);
    }

    @Override
    protected void initView(Context context) {
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                loadView.release();
            }
        });
    }

    @Override
    public void show() {
        loadView.start();
        super.show();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.dialog_loading;
    }

    public void setMsg(String msg) {
        loadingText.setText(msg);
    }

    public void setCancle(boolean isCancle) {
        setCancelable(isCancle);
        setCanceledOnTouchOutside(isCancle);
    }
}
