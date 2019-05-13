package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.hook.HookHelper;

/**
 * create by xujixiao on 2019/5/13 10:31
 */
public class AppApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        HookHelper.hookNotifaction(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

}
