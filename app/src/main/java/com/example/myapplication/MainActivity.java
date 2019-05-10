package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        测试使用layout的分包整理策略，涉及到build.gradle文件中sourceset节点的修改配置
        setContentView(R.layout.new_main_layout);
        findViewById(R.id.tv_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_LONG).show();
            }
        });
    }
}
