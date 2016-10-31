package com.ghx.app.utils;

import android.util.Log;

/**
 * Created by guo_hx on 2016/10/31.14:51
 */

public class Logger {

    private static final String DEFAULT_TAG = "guohongxin";

    public static void log_i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void log_i(String msg) {
        log_i(DEFAULT_TAG, msg);
    }
}
