package com.ilanchuang.slog.helper;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util
        .AppUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.dianping.logan.Logan;
import com.dianping.logan.LoganConfig;
import com.dianping.logan.SendLogCallback;
import com.ilanchuang.slog.Slog;
import com.ilanchuang.slog.config.SuoiLogConfig;
import com.ilanchuang.slog.manager.LogManager;

import java.util.Formatter;

/**
 * ClassName: SLocalLogHelepr
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0
 * Description:
 **/
public class SLocalLogHelepr implements ILogHelper {
    private static final int MIN_STACK_OFFSET = 5;
    private static SLocalLogHelepr mInstance;
    private static SuoiLogConfig mConfig;
    private static final int V = 2;
    private static final int D = 3;
    private static final int I = 4;
    private static final int W = 5;
    private static final int E = 6;
    private static final int JSON = 7;

    private SLocalLogHelepr(SuoiLogConfig config) {
        mConfig = config;
        LoganConfig mLoganConfig = new LoganConfig.Builder()
                .setCachePath(config.getCachePath())
                .setPath(config.getSavePath())
                .setEncryptKey16("0123456789012345".getBytes())
                .setEncryptIV16("0123456789012345".getBytes())
                .build();
        Logan.setDebug(config.isDebug());
        Logan.init(mLoganConfig);
    }

    public static SLocalLogHelepr getInstance(SuoiLogConfig config) {
        if (mInstance == null) {
            synchronized (SLocalLogHelepr.class) {
                if (mInstance == null) {
                    mInstance = new SLocalLogHelepr(config);
                }
                return mInstance;
            }
        }
        return mInstance;
    }

    @Override
    public void i(String content) {
        write(formatContent(mConfig.getTag(), content), I);
    }

    @Override
    public void i(String TAG, String content) {
        write(formatContent(TAG, content), I);

    }

    @Override
    public void e(String content) {
        write(formatContent(mConfig.getTag(), content), E);
    }

    @Override
    public void e(String TAG, String content) {
        write(formatContent(TAG, content), E);
    }

    @Override
    public void w(String content) {
        write(formatContent(mConfig.getTag(), content), W);

    }

    @Override
    public void w(String TAG, String content) {
        write(formatContent(TAG, content), W);

    }

    @Override
    public void v(String content) {
        write(formatContent(mConfig.getTag(), content), V);
    }

    @Override
    public void v(String TAG, String content) {
        write(formatContent(TAG, content), V);
    }

    @Override
    public void d(String content) {
        write(formatContent(mConfig.getTag(), content), D);
    }

    @Override
    public void d(String TAG, String content) {
        write(formatContent(TAG, content), D);
    }

    @Override
    public void json(String json) {
        write(formatContent(mConfig.getTag(), json), JSON);
    }

    @Override
    public void json(String TAG, String json) {
        write(formatContent(TAG, json), JSON);
    }

    public void write(String content, int type) {
        Logan.w(content, type);
    }

    @Override
    public void flush() {
        Logan.f();
    }

    private static String formatContent(String TAG, String content) {
        if (mConfig.getLogType() == SuoiLogConfig.LogType.DETAIL) {
            return getThreadInfo() + "|" + TAG + "  |  " + content;
        } else {
            return TAG + "  |  " + content;
        }
    }

    private static String getThreadInfo() {
        final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        final int stackIndex = getStackOffset(stackTrace);
        StackTraceElement targetElement = stackTrace[stackIndex];
        String tName = Thread.currentThread().getName();
        String head = new Formatter()
                .format("%s |  %s |  %s   (%s:%d)",
                        tName,
                        targetElement.getClassName(),
                        targetElement.getMethodName(),
                        targetElement.getFileName(),
                        targetElement.getLineNumber())
                .toString();
        return head;
    }


    private static int getStackOffset(@NonNull StackTraceElement[] trace) {
        for (int i = MIN_STACK_OFFSET; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(SLocalLogHelepr.class.getName()) && !name.equals(LogManager.class.getName()) && !name.equals(Slog.class.getName())) {
                return --i;
            }
        }
        return -1;
    }

    private String getSimpleClassName(@NonNull String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    public void upload(final OnLogUploadListener listener) {
        if (TextUtils.isEmpty(mConfig.getDEVICEID())) {
            throw new NullPointerException("Logan DEVICEID  is null!!");
        }
        if (TextUtils.isEmpty(mConfig.getAPPID())) {
            throw new NullPointerException("Logan APPID is null!!");
        }
        String uniondID = TextUtils.isEmpty(mConfig.getUnionId()) ? mConfig.getDEVICEID() : mConfig.getUnionId();
        Logan.s(mConfig.getUploadUrl(), TimeUtils.getNowString(),
                mConfig.getAPPID(), uniondID, mConfig.getDEVICEID(),
                String.valueOf(AppUtils.getAppVersionCode()),
                String.valueOf(AppUtils.getAppVersionName()), new SendLogCallback() {
                    @Override
                    public void onLogSendCompleted(int statusCode, byte[] data) {
                        if (listener != null) {
                            final String resultData = data != null ? new String(data) : "";
                            listener.onCompleted(statusCode, resultData);
                        }
                    }
                });
    }


    public interface OnLogUploadListener {
        void onCompleted(int code, String msg);
    }


}
