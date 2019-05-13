package com.example.myapplication.hook;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Filter;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by xujixiao on 2019/5/10 10:27
 * 协助hook监听事件的帮助类
 */
public class HookHelper {
    /**
     * hook的核心方法
     *
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

    /**
     * hook系统的通知
     * @param context
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void hookNotifaction(final Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            Method method = null;
            method = NotificationManager.class.getDeclaredMethod("getService");
            method.setAccessible(true);
            final Object service = method.invoke(notificationManager);

            Class manager = Class.forName("android.app.INotificationManager");
            Object proxyNotificationManager = Proxy.newProxyInstance(context.getClass().getClassLoader(),
                    new Class[]{manager},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Toast.makeText(context, "劫持notificationmanager", Toast.LENGTH_LONG).show();
                            if (args != null && args.length > 0) {
                                for (Object arg : args) {
                                    Log.d("xujixiao", arg!=null?arg.getClass().toString():"");
                                    if (arg != null && arg instanceof Notification) {
                                        Notification notification = (Notification) arg;
                                        String temp = null;
                                        if (notification.tickerText!=null) {
                                            temp = notification.tickerText.toString();
                                        }
                                        Log.d("xujixiao", temp);
                                    }
                                }
                            }
                            Log.d("xujixiao", method.getName());
                            return method.invoke(service, args);
                        }
                    });

            Field field = NotificationManager.class.getDeclaredField("sService");
            field.setAccessible(true);
            field.set(notificationManager, proxyNotificationManager);
            Log.d("xujixiao", "hook notification manager success");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "hook失败", Toast.LENGTH_LONG).show();
    }

    }
}


