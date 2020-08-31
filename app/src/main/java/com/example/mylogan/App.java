package com.example.mylogan;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.PathUtils;
import com.ilanchuang.slog.config.SuoiLogConfig;
import com.ilanchuang.slog.config.SuoiLogConfigBuilder;
import com.ilanchuang.slog.manager.LogManager;


/**
 * @ClassName: App
 * @Author: zzw
 * @Email: zhengzhiwei333@gmail.com
 * @Version: 1.0
 * @Description:
 **/
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SuoiLogConfig suoiLogConfig = new SuoiLogConfigBuilder().setDebug(true).setDeviceId("111").
                setAppId("0001").setSaveDay(7).setTAG("XIAOITV").setLogType(SuoiLogConfig.LogType.DETAIL)
                .setSavePath(PathUtils.getInternalAppFilesPath() + "log_v1")
                .setCachePath(PathUtils.getInternalAppCachePath())
                .setPrintLocal(true)
                .setUploadUrl("http://helloz.top:8080/logan/logan/upload.json")
                .setUnionId("000001").build();
        LogManager.init(suoiLogConfig);
    }


    private static Context context;

    public static Context getContext() {
        return context;
    }
}
