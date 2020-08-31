package com.ilanchuang.slog.manager;

import android.text.TextUtils;

import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.ilanchuang.slog.common.GlobalConstant;
import com.ilanchuang.slog.config.SuoiLogConfig;
import com.ilanchuang.slog.config.SuoiLogConfigBuilder;
import com.ilanchuang.slog.helper.SLocalLogHelepr;
import com.ilanchuang.slog.helper.SLogHelper;

/**
 * ClassName: LogManager
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0.3
 * Description: 管理类
 **/
public class LogManager {
    private static SuoiLogConfig mConfig;
    private static SuoiLogConfig mDefulatConfig;
    private static SLogHelper sLogHelper;
    private static SLocalLogHelepr sLocalLogHelepr;


    public static void init(String appID) {
        SuoiLogConfig config = getDefulatSuoiLogConfig();
        config.setAppID(appID);
        init(config);
    }

    public static void init(SuoiLogConfig config) {
        setLogConfig(config);
        init();
    }

    private static void init() {
        sLogHelper = SLogHelper.getInstance(getSuoiLogConfig());
        sLocalLogHelepr = SLocalLogHelepr.getInstance(getSuoiLogConfig());
    }


    private static void setLogConfig(SuoiLogConfig config) {
        mConfig = config;
    }


    private static SuoiLogConfig getSuoiLogConfig() {
        if (TextUtils.isEmpty(mConfig.getTag())) {
            mConfig.setTag(getDefulatSuoiLogConfig().getTag());
        }
        if (TextUtils.isEmpty(mConfig.getCachePath())) {
            mConfig.setCachePath(getDefulatSuoiLogConfig().getCachePath());
        }
        if (TextUtils.isEmpty(mConfig.getSavePath())) {
            mConfig.setSavePath(getDefulatSuoiLogConfig().getSavePath());
        }
        if (TextUtils.isEmpty(mConfig.getDeviceID())) {
            mConfig.setDeviceID(getDefulatSuoiLogConfig().getDeviceID());
        }
        if (mConfig.getSaveDay() <= 0) {
            mConfig.setSaveDay(getDefulatSuoiLogConfig().getSaveDay());
        }
        if (mConfig.getSaveSize() <= 0) {
            mConfig.setSaveSize(getDefulatSuoiLogConfig().getSaveSize());
        }
        return mConfig;
    }

    private void setUnionID(String unionID) {
        mConfig.setUnionId(unionID);
    }

    private void setDeviceID(String deviceID) {
        mConfig.setDeviceID(deviceID);
    }

    private void setEnable(boolean enable) {
        mConfig.setEnable(enable);
    }

    private boolean getEnable() {
        return mConfig.getEnable();
    }

    private static SuoiLogConfig getDefulatSuoiLogConfig() {
        if (mDefulatConfig == null) {
            mDefulatConfig = new SuoiLogConfigBuilder().setDebug(true).setSaveDay(GlobalConstant.SAVE_DAY)
                    .setSaveSize(GlobalConstant.SAVE_SIZE).setPrintLocal(true).setTAG(GlobalConstant.TAG)
                    .setSavePath(PathUtils.getInternalAppFilesPath() + "log_v1")
                    .setCachePath(PathUtils.getInternalAppCachePath())
                    .setLogType(SuoiLogConfig.LogType.DETAIL)
                    .setUploadUrl(GlobalConstant.UPLOAD_URL)
                    .setDeviceId(PhoneUtils.getDeviceId())
                    .build();
        }
        return mDefulatConfig;
    }

    public static void i(String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.i(content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.i(content);
            }
        }

    }

    public static void i(String TAG, String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.i(TAG, content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.i(TAG, content);
            }
        }
    }

    public static void e(String content) {
        if (getSuoiLogConfig().getEnable()) {
            if (getSuoiLogConfig().getEnable()) {
                sLocalLogHelepr.e(content);
                if (getSuoiLogConfig().isDebug()) {
                    sLogHelper.e(content);
                }
            }
        }
    }

    public static void e(String TAG, String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.e(TAG, content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.e(TAG, content);
            }
        }
    }

    public static void w(String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.w(content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.w(content);
            }
        }
    }

    public static void w(String TAG, String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.w(TAG, content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.w(TAG, content);
            }
        }
    }

    public static void v(String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.v(content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.v(content);
            }
        }
    }

    public static void flush() {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.flush();
        }
    }

    public static void v(String TAG, String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLogHelper.v(TAG, content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.v(TAG, content);
            }
        }
    }

    public static void d(String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.d(content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.d(content);
            }
        }
    }

    public static void d(String TAG, String content) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.d(TAG, content);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.d(TAG, content);
            }
        }
    }

    public static void json(String json) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.json(json);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.json(json);
            }
        }
    }

    public static void json(String TAG, String json) {
        if (getSuoiLogConfig().getEnable()) {
            sLogHelper.json(TAG, json);
            if (getSuoiLogConfig().isDebug()) {
                sLogHelper.json(TAG, json);
            }
        }
    }

    public static void upload(SLocalLogHelepr.OnLogUploadListener listener) {
        if (getSuoiLogConfig().getEnable()) {
            sLocalLogHelepr.upload(listener);
        }
    }

}


