package com.example.myapplication.activityfragemnttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.myapplication.R;

/**
 * create by xujixiao on 2019-09-10 14:03
 */
public class TestDataActivity extends FragmentActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, TestDataActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);
//        findViewById(R.id.fl_activity)
        getSupportFragmentManager().beginTransaction().add(R.id.fl_activity, TestFragment.newInstance()).commitAllowingStateLoss();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("xujixiao", "TestDataActivity---requestCode---" + requestCode + "---resultCode--" + resultCode + "----data---" + data.getStringExtra("data"));
    }
}
