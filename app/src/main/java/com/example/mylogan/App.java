package com.example.mylogan;

import android.app.Application;
import android.content.Context;

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
        LogManager.init("121345");
    }


    private static Context context;

    public static Context getContext() {
        return context;
    }
}
