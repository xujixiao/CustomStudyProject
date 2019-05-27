package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.databinding.NewMainLayoutBinding;
import com.example.myapplication.hook.HookHelper;
import com.example.myapplication.hook.NotificationUtils;
import com.example.myapplication.kotin.SecondActivity;
import com.example.myapplication.kotin.StudentKotlin;
import com.example.myapplication.kotin.TestEntity;
import com.example.myapplication.kotin.TestStudentLombox;
import com.orhanobut.logger.Logger;

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {


    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        测试使用layout的分包整理策略，涉及到build.gradle文件中sourceset节点的修改配置
//        setContentView(R.layout.new_main_layout);
        NewMainLayoutBinding mainLayoutBinding =
                DataBindingUtil.setContentView(this, R.layout.new_main_layout);
        NewMainLayoutBinding newMainLayoutBinding =
                DataBindingUtil.findBinding(getWindow().getDecorView().findViewById(R.id.tv_main));
        if (newMainLayoutBinding != null) {
            newMainLayoutBinding.tvMain.setText("databinding测试");
        }

        /*使用hook技术hook onclicklistener 方法添加一些额外的操作*/
        View.OnClickListener testClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LoginActivity.start(MainActivity.this);
                SecondActivity.Companion.start(MainActivity.this);
            }
        };
        findViewById(R.id.tv_main).setOnClickListener(testClick);
        HookHelper.hook(this, findViewById(R.id.tv_main));

        NotificationUtils.sendNotification(this);

        TestEntity testEntity = new TestEntity();
        testEntity.setName("xujxiiao");
        testEntity.setSubName("xujixiao");


        TestStudentLombox studentLombox = new TestStudentLombox();
        studentLombox.setName("xujxiiao").setAge("xujixiao");
        studentLombox.setName("xujxiiao").setAge("xujixiao");


        StudentKotlin studentKotlin = new StudentKotlin("xujixiao", 0);
//        studentKotlin.setAge2();
        showName(studentKotlin);


    }

    /**
     * 初始化腾讯的mmkv框架的方式。
     */
    private void initMMKV() {
//        String rootDir = MMKV.initialize(this);
//        Log.d("xujixiao", rootDir);
    }

    /**
     *
     */
    private static <T> void showName(T t) {
        Logger.d(t);
    }
}
