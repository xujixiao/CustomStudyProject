package com.example.myapplication.testdata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * create by xujixiao on 2019-09-10 14:03
 */
public class FirstActivity extends Activity {
    public static void start(Context context) {
        Intent starter = new Intent(context, FirstActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);
        TextView text = findViewById(R.id.tv_test_first);
        text.setText("第一个");
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 10);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
                        startActivityForResult(intent, 20);
                    }
                }, 1000);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("xujixiao", "first---requestCode---" + requestCode + "---resultCode--" + resultCode + "----data---" + data.getStringExtra("data"));
    }
}
