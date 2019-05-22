package com.example.myapplication

import com.example.myapplication.kotin.StudentKotlin

/**
 * create by xujixiao on 2019-05-22 14:44
 */
class TestKotlinCotent {

    fun test() {
        val studentKotlin = StudentKotlin("zhang",90)
        studentKotlin.let {
            it.name = "xujixiao"
            it.age = 23
        }
        studentKotlin.run {
            name = "xujixiao"
            age = 89
        }
        println(studentKotlin.toString())
    }
}