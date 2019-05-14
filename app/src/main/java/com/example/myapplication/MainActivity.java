package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.hook.HookHelper;
import com.example.myapplication.hook.NotificationUtils;
import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        测试使用layout的分包整理策略，涉及到build.gradle文件中sourceset节点的修改配置
        setContentView(R.layout.new_main_layout);

        /*使用hook技术hook onclicklistener 方法添加一些额外的操作*/
        View.OnClickListener testClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_LONG).show();
            }
        };
        findViewById(R.id.tv_main).setOnClickListener(testClick);
        HookHelper.hook(this,findViewById(R.id.tv_main));

        NotificationUtils.sendNotification(this);

        initMMKV();
    }

    private void initMMKV(){
        String rootDir = MMKV.initialize(this);
        Log.d("xujixiao", rootDir);
    }
}
