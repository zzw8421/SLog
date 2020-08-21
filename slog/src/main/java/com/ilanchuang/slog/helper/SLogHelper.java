package com.ilanchuang.slog.helper;

import com.blankj.utilcode.util.LogUtils;
import com.ilanchuang.slog.config.SuoiLogConfig;

/**
 * ClassName: SLogHelper
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0
 * Description:
 **/
public class SLogHelper implements ILogHelper {

    private static SLogHelper mInstance;

    private SLogHelper(SuoiLogConfig config) {
        LogUtils.getConfig().setGlobalTag(config.getTag());
        LogUtils.getConfig().setLogSwitch(config.isDebug());
        LogUtils.getConfig().setLog2FileSwitch(false);
        LogUtils.getConfig().setStackOffset(3);
        if (config.getLogType() == SuoiLogConfig.LogType.DETAIL) {
            LogUtils.getConfig().setLogHeadSwitch(true);
            LogUtils.getConfig().setBorderSwitch(true);
        } else {
            LogUtils.getConfig().setLogHeadSwitch(false);
            LogUtils.getConfig().setBorderSwitch(false);
        }
    }

    public static SLogHelper getInstance(SuoiLogConfig config) {
        if (mInstance == null) {
            synchronized (SLogHelper.class) {
                if (mInstance == null) {
                    mInstance = new SLogHelper(config);
                }
                return mInstance;
            }
        }
        return mInstance;
    }

    public static void init(SuoiLogConfig config) {
        getInstance(config);
    }

    @Override
    public void i(String content) {
        LogUtils.i(content);
    }

    @Override
    public void i(String TAG, String content) {
        LogUtils.iTag(TAG, content);

    }

    @Override
    public void e(String content) {
        LogUtils.e(content);

    }

    @Override
    public void e(String TAG, String content) {
        LogUtils.eTag(TAG, content);
    }

    @Override
    public void w(String content) {
        LogUtils.w(content);

    }

    @Override
    public void w(String TAG, String content) {
        LogUtils.wTag(TAG, content);

    }

    @Override
    public void v(String content) {
        LogUtils.v(content);

    }

    @Override
    public void v(String TAG, String content) {
        LogUtils.vTag(TAG, content);

    }

    @Override
    public void d(String content) {
        LogUtils.d(content);

    }

    @Override
    public void d(String TAG, String content) {
        LogUtils.dTag(TAG, content);
    }

    @Override
    public void json(String json) {
        LogUtils.json(json);
    }

    @Override
    public void json(String TAG, String json) {
        LogUtils.json(TAG, json);
    }

    @Override
    public void flush() {

    }
}
