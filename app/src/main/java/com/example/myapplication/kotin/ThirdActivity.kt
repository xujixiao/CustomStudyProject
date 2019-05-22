package com.example.myapplication.kotin

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * create by xujixiao on 2019-05-22 16:18
 */
class ThirdActivity : Activity() {
    companion object {
        fun start(context: Context) {
            val starter = Intent(context, ThirdActivity::class.java)
//            starter.putExtra();
            context.startActivity(starter)
        }
    }



}
