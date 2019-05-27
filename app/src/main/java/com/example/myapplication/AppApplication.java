package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.myapplication.hook.HookHelper;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * create by xujixiao on 2019/5/13 10:31
 */
public class AppApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        HookHelper.hookNotifaction(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //添加埋点功能的框架
        MixpanelAPI mixpanelAPI = MixpanelAPI.getInstance(this, "");
        mixpanelAPI.track("xujixiao");

        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
