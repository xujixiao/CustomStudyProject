package com.example.myapplication.kotin

import lombok.Data
import lombok.EqualsAndHashCode
import lombok.experimental.Accessors

/**
 * create by xujixiao on 2019-05-22 11:50
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
class TestEntity {
    var name: String? = null
    var subName: String? = null
    val age: Int? = null
}