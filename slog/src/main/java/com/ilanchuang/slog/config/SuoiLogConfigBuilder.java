package com.ilanchuang.slog.config;

/**
 * ClassName: SuoiLogConfigFactory
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0
 * Description: 创建日志的配置
 **/
public class SuoiLogConfigBuilder {
    private SuoiLogConfig mConfig;

    public SuoiLogConfigBuilder() {
        mConfig = new SuoiLogConfig();
    }

    public SuoiLogConfigBuilder setAppId(String APPID) {
        this.mConfig.setAPPID(APPID);
        return this;
    }

    public SuoiLogConfigBuilder setDeviceId(String DEVICEID) {
        this.mConfig.setDEVICEID(DEVICEID);
        return this;
    }

    public SuoiLogConfigBuilder setDebug(boolean debug) {
        mConfig.setDebug(debug);
        return this;
    }

    public SuoiLogConfigBuilder setSaveDay(int day) {
        mConfig.setSaveDay(day);
        return this;
    }

    public SuoiLogConfigBuilder setSaveSize(long size) {
        mConfig.setSaveSize(size);
        return this;
    }

    public SuoiLogConfigBuilder setUploadUrl(String url) {
        mConfig.setUploadUrl(url);
        return this;
    }

    public SuoiLogConfigBuilder setPrintLocal(boolean print) {
        mConfig.setPrintLocal(print);
        return this;
    }

    public SuoiLogConfigBuilder setTAG(String tag) {
        mConfig.setTag(tag);
        return this;
    }

    public SuoiLogConfigBuilder setSavePath(String path) {
        mConfig.setSavePath(path);
        return this;
    }

    public SuoiLogConfigBuilder setCachePath(String path) {
        mConfig.setCachePath(path);
        return this;
    }

    public SuoiLogConfigBuilder setLogType(SuoiLogConfig.LogType type) {
        mConfig.setLogType(type);
        return this;
    }

    public SuoiLogConfigBuilder setUnionId(String unionId) {
        mConfig.setUnionId(unionId);
        return this;
    }

    public SuoiLogConfig build() {
        return mConfig;
    }

}
