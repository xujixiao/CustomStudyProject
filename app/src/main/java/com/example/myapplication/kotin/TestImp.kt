package com.example.myapplication.kotin

/**
 * create by xujixiao on 2019-05-22 15:45
 */
class TestImp : TestInterface {
    override fun showName() {
        println("徐杰差额")
    }

    fun showSubName() {
        print("zhang")
    }

    companion object {
        @JvmField
        val jvmName: String = "zhangjvm"

        @JvmStatic
        fun showJvmName(): String {
            return jvmName
        }
    }
}