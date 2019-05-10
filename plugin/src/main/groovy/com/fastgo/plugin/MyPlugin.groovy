package com.fastgo.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 创建自定义的plugin的插件
 */
public class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
//        定义一个自定义的任务执行，依赖插件之后，执行./gradlew hellobike
        project.task("helloxujixiao"){
            doLast{
                println("hello first plugin")
            }
        }
    }
}