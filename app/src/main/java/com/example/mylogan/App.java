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
                setAppId("111").setSaveDay(5).setTAG("XIAOITV").setLogType(SuoiLogConfig.LogType.DETAIL)
                .setSavePath(PathUtils.getInternalAppFilesPath() + "log_v1")
                .setCachePath(PathUtils.getInternalAppCachePath())
                .setPrintLocal(true)
                .setUploadUrl("http://192.168.88.183:8080/logan_web_war_exploded/logan/upload.json")
                .setUnionId("121231").build();
        LogManager.init(suoiLogConfig);
    }


    private static Context context;

    public static Context getContext() {
        return context;
    }
}
