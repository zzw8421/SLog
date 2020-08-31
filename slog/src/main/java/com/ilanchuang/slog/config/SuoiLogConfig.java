package com.ilanchuang.slog.config;

/**
 * ClassName: SuoiLogConfig
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0
 * Description:
 **/
public class SuoiLogConfig {
    //设置自动上传或者被动上传
    //设置文件存储路径 缓存路径
    //设置文件大小及存储天数
    //设置文件APPID
    //设置文件设备ID
    //设置用户ID
    //设置上传路径
    //设置是否打印 DEUBG LOG
    //设置是否只打印内存的 不存储在本地文件中
    private boolean mDebug;
    private int mSaveDay;
    private long mSaveSize;
    private String appID;
    private String deviceID;
    private String mUploadUrl;
    private boolean printLocal;
    private String mTag;
    private String mCachePath;
    private String mSavePath;
    private LogType mLogType;
    private String mUnionId;
    private boolean enable = true;

    public SuoiLogConfig() {
        mLogType = LogType.DETAIL;
    }

    public SuoiLogConfig(boolean mDebug, int mSaveDay, long mSaveSize, String appID, String deviceID, String mUploadUrl, boolean printLocal, String mTag) {
        this.mDebug = mDebug;
        this.mSaveDay = mSaveDay;
        this.mSaveSize = mSaveSize;
        this.appID = appID;
        this.deviceID = deviceID;
        this.mUploadUrl = mUploadUrl;
        this.printLocal = printLocal;
        this.mTag = mTag;
    }


    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean getEnable() {
        return this.enable;
    }

    public boolean isDebug() {
        return mDebug;
    }

    public void setDebug(boolean mDebug) {
        this.mDebug = mDebug;
    }

    public int getSaveDay() {
        return mSaveDay;
    }

    public void setSaveDay(int mSaveDay) {
        this.mSaveDay = mSaveDay;
    }

    public long getSaveSize() {
        return mSaveSize * 1024 * 1024;
    }

    public void setSaveSize(long mSaveSize) {
        this.mSaveSize = mSaveSize;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getUploadUrl() {
        return mUploadUrl;
    }

    public void setUploadUrl(String mUploadUrl) {
        this.mUploadUrl = mUploadUrl;
    }

    public boolean isPrintLocal() {
        return printLocal;
    }

    public void setPrintLocal(boolean printLocal) {
        this.printLocal = printLocal;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }

    public String getCachePath() {
        return mCachePath;
    }

    public String getUnionId() {
        return mUnionId;
    }

    public void setUnionId(String mUnionId) {
        this.mUnionId = mUnionId;
    }

    public void setCachePath(String mCachePath) {
        this.mCachePath = mCachePath;
    }

    public String getSavePath() {
        return mSavePath;
    }

    public void setSavePath(String mSavePath) {
        this.mSavePath = mSavePath;
    }

    public LogType getLogType() {
        return mLogType;
    }

    public void setLogType(LogType mLogType) {
        this.mLogType = mLogType;
    }

    public enum LogType {
        DETAIL, SIMPLE
    }
}
