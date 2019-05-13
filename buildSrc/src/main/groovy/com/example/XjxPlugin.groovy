package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

public class XjxPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        System.out.println("第二个简单的自定义插件")
        println("项目的目录："+project.rootDir)

    }
}