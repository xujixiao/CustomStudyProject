package com.example.myapplication.hook;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.example.myapplication.R;

/**
 * create by xujixiao on 2019/5/13 10:38
 */
public class NotificationUtils {
    public static void sendNotification(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).setContentText("测试通知");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("测试的ticket");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }

}
