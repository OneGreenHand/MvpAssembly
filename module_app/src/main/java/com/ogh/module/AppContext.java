package com.ogh.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.ogh.module.common.base.BaseApplication;
import com.ogh.module.common.config.AppConfig;
import com.ogh.module.common.config.BaseConfig;
import com.ogh.module.common.config.Config;
import com.ogh.module.common.util.CommonUtil;
import com.tencent.bugly.beta.Beta;

import java.io.File;

/**
 * 这里仅需做一些初始化的工作
 */
public class AppContext extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //     Bugly.init(getApplicationContext(), "f2b3e1f187", false);//初始化bugly
        Utils.init(this);//初始化工具类
        if (AppConfig.DEBUG) {         // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        //  createFolder();
    }

    /**
     * 不改变Oncreate()方法中的业务逻辑
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
        // 安装tinker插件
        Beta.installTinker();
    }

    /**
     * 创建文件夹
     */
    @SuppressLint("MissingPermission")
    private void createFolder() {
        // 创建app目录
        File dir = new File(BaseConfig.APP_FOLDER);
        if (!dir.exists()) {
            dir.mkdir();
        }
//        //创建photo目录
//        File photosDir = new File(BaseConfig.PHOTO_FOLDER);
//        if (!photosDir.exists()) {
//            photosDir.mkdir();
//        }
        //创建file目录
        File fileDir = new File(BaseConfig.FILE_FOLDER);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
    }
}
