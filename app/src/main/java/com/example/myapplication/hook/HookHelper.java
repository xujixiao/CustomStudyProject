package com.example.myapplication.hook;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * create by xujixiao on 2019/5/10 10:27
 * 协助hook监听事件的帮助类
 */
public class HookHelper {
    /**
     * hook的核心方法
     * @param context
     * @param view
     */
    public static void hook(Context context, final View view) {
        Method method = null;
        try {
            //获取getlistenerinfo的方法，不可访问的
            method = View.class.getDeclaredMethod("getListenerInfo");
            //设置可访问权限
            method.setAccessible(true);

            Object mListenerInfo = method.invoke(view);//获取到实际的listenerInfo对象
            Class<?> listenerInfo = Class.forName("android.view.View$ListenerInfo");
            Field field = listenerInfo.getDeclaredField("mOnClickListener");//获取对应的成员变量
            View.OnClickListener onClickListener = (View.OnClickListener) field.get(mListenerInfo);//获取实际的成员变量值
            ProxyClick proxyClick = new ProxyClick(onClickListener);//设置到代理对象
            field.set(mListenerInfo, proxyClick);//使用代理对象替换实际的mOnClickListener
            //这样在调用监听事件的时候就会执行代理方法中的一些额外工作
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("xujixiao", "no such method exceptions throw ");
        }

    }
}
