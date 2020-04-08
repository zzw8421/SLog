package com.ilanchuang.slog.manager;
import android.content.Context;
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
 * Version: 1.0
 * Description: 管理类
 **/
public class LogManager {
    private static LogManager mInstance;
    private Context mContext;
    private static SuoiLogConfig mConfig;
    private static SuoiLogConfig mDefulatConfig;
    private static SLogHelper sLogHelper;
    private static SLocalLogHelepr sLocalLogHelepr;

    private LogManager(SuoiLogConfig config) {
        mConfig = config;
        init();
    }

    public static LogManager getInstance(SuoiLogConfig config) {
        if (mInstance == null) {
            synchronized (LogManager.class) {
                if (mInstance == null) {
                    mInstance = new LogManager(config);
                }
                return mInstance;
            }
        }
        return mInstance;
    }

    public static void init(SuoiLogConfig config) {
        getInstance(config);
    }

    private static void init() {
        sLogHelper = SLogHelper.getInstance(getSuoiLogConfig());
        sLocalLogHelepr = SLocalLogHelepr.getInstance(getSuoiLogConfig());
    }

    public static void init(String APPID) {
        SuoiLogConfig config = getDefulatSuoiLogConfig();
        config.setAPPID(APPID);
        getInstance(config);
    }

    public static void setLogConfig(SuoiLogConfig config) {
        mConfig = config;
    }


    public static SuoiLogConfig getSuoiLogConfig() {
        if (mConfig == null) {
            throw new NullPointerException("未配置config文件,init error");
        }
        if (TextUtils.isEmpty(mConfig.getTag())) {
            mConfig.setTag(getDefulatSuoiLogConfig().getTag());
        }
        if (TextUtils.isEmpty(mConfig.getCachePath())) {
            mConfig.setCachePath(getDefulatSuoiLogConfig().getCachePath());
        }
        if (TextUtils.isEmpty(mConfig.getSavePath())) {
            mConfig.setSavePath(getDefulatSuoiLogConfig().getSavePath());
        }
        if (TextUtils.isEmpty(mConfig.getDEVICEID())) {
            mConfig.setDEVICEID(getDefulatSuoiLogConfig().getDEVICEID());
        }
        if (mConfig.getSaveDay() <= 0) {
            mConfig.setSaveDay(getDefulatSuoiLogConfig().getSaveDay());
        }
        if (mConfig.getSaveSize() <= 0) {
            mConfig.setSaveSize(getDefulatSuoiLogConfig().getSaveSize());
        }
        return mConfig;
    }

    public static SuoiLogConfig getDefulatSuoiLogConfig() {
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
        sLocalLogHelepr.i(content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.i(content);
        }
    }

    public static void i(String TAG, String content) {
        sLocalLogHelepr.i(TAG, content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.i(TAG, content);
        }
    }

    public static void e(String content) {
        sLocalLogHelepr.e(content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.e(content);
        }
    }

    public static void e(String TAG, String content) {
        sLocalLogHelepr.e(TAG, content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.e(TAG, content);
        }
    }

    public static void w(String content) {
        sLocalLogHelepr.w(content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.w(content);
        }
    }

    public static void w(String TAG, String content) {
        sLocalLogHelepr.w(TAG, content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.w(TAG, content);
        }
    }

    public static void v(String content) {
        sLocalLogHelepr.v(content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.v(content);
        }
    }

    public static void v(String TAG, String content) {
        sLogHelper.v(TAG, content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.v(TAG, content);
        }
    }

    public static void d(String content) {
        sLocalLogHelepr.d(content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.d(content);
        }
    }

    public static void d(String TAG, String content) {
        sLocalLogHelepr.d(TAG, content);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.d(TAG, content);
        }
    }

    public static void json(String json) {
        sLocalLogHelepr.json(json);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.json(json);
        }
    }

    public static void json(String TAG, String json) {
        sLogHelper.json(TAG, json);
        if (getSuoiLogConfig().isDebug()) {
            sLogHelper.json(TAG, json);
        }
    }

    public static void upload(SLocalLogHelepr.OnLogUploadListener listener) {
        sLocalLogHelepr.upload(listener);
    }

}


