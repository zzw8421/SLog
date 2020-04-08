package com.ilanchuang.slog;

import com.ilanchuang.slog.helper.SLocalLogHelepr;
import com.ilanchuang.slog.manager.LogManager;

/**
 * ClassName: Slog
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0
 * Description: 所依日志
 **/
public class Slog {
    public static void i(String content) {
        LogManager.i(content);
    }

    public static void i(String TAG, String content) {
        LogManager.i(TAG, content);

    }

    public static void e(String content) {
        LogManager.e(content);

    }

    public static void e(String TAG, String content) {
        LogManager.e(TAG, content);

    }

    public static void w(String content) {
        LogManager.w(content);

    }

    public static void w(String TAG, String content) {
        LogManager.w(TAG, content);

    }

    public static void v(String content) {
        LogManager.i(content);

    }

    public static void v(String TAG, String content) {
        LogManager.v(TAG, content);

    }

    public static void d(String content) {
        LogManager.d(content);

    }

    public static void d(String TAG, String content) {
        LogManager.d(TAG, content);

    }

    public static void json(String json) {
        LogManager.json(json);

    }

    public static void json(String TAG, String json) {
        LogManager.json(TAG, json);
    }

    public static void upload(SLocalLogHelepr.OnLogUploadListener listener) {
        LogManager.upload(listener);
    }

}
