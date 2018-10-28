package com.jackie.testmmkv;

import android.app.Application;
import android.util.Log;

import com.tencent.mmkv.MMKV;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        String path = MMKV.initialize(this);
        Log.i(TAG, "onCreate: ----"+path);
    }
}
