package com.example.myapplication.testdata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * create by xujixiao on 2019-09-10 14:03
 */
public class SecondActivity extends Activity {


    public static void start(Context context) {
        Intent starter = new Intent(context, SecondActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);
        TextView text = findViewById(R.id.tv_test_first);
        text.setText("第二个");
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data", "second_data-20");
                setResult(20, intent);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("xujixiao", "Second---requestCode---" + requestCode + "---resultCode--" + resultCode + "----data---" + data.getStringExtra("data"));
    }
}
