package com.example.myapplication.kotin

import android.app.Activity
import android.app.LauncherActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * create by xujixiao on 2019-05-22 15:45
 */
class SecondActivity : Activity() {

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SecondActivity::class.java)
//            starter.putExtra();
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_test_kotlin.text = "测试kotlin的扩展用法"
        tv_test_kotlin.setOnClickListener {
            Log.d("xujixiao", "开始启动协程")
            GlobalScope.launch(Dispatchers.Main) {
                val string = sleepTime()
                Toast.makeText(this@SecondActivity, string, Toast.LENGTH_LONG).show()
                tv_test_kotlin.text = string
            }
        }
    }

    suspend fun sleepTime(): String {
        Thread.sleep(4000)
        return "睡醒了"
    }
}