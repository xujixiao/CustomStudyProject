package com.example.myapplication.activityfragemnttest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log

import com.example.myapplication.R

/**
 * create by xujixiao on 2019-09-10 14:03
 */
class TestDataActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_layout)
        //        findViewById(R.id.fl_activity)
        supportFragmentManager.beginTransaction().add(R.id.fl_activity, TestFragment.newInstance()).commitAllowingStateLoss()
        var widthPercent = 1f / 2f

        Log.d("xujixiao", "数量" + widthPercent)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("xujixiao", "TestDataActivity---requestCode---" + requestCode + "---resultCode--" + resultCode + "----data---" + data!!.getStringExtra("data"))
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, TestDataActivity::class.java)
            //        starter.putExtra();
            context.startActivity(starter)
        }
    }
}
