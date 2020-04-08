package com.ilanchuang.slog.helper;

/**
 * ClassName: ILogHelper
 * Author: zzw
 * Email: zhengzhiwei333@gmail.com
 * Version: 1.0
 * Description:
 **/
public interface ILogHelper {
    void i(String content);

    void i(String TAG, String content);

    void e(String content);

    void e(String TAG, String content);

    void w(String content);

    void w(String TAG, String content);

    void v(String content);

    void v(String TAG, String content);

    void d(String content);

    void d(String TAG, String content);

    void json(String json);

    void json(String TAG, String json);

}
