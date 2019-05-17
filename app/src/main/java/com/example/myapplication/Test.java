package com.example.myapplication;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import org.w3c.dom.ProcessingInstruction;

import java.util.logging.Handler;

/**
 * create by xujixiao on 2019/5/15 20:58
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "xujixiao";
        student.age = null;
        student.man = true;
        String json = new Gson().toJson(student);
        System.out.println(json);
//        json = json.replace("90", "null");
//        System.out.println(json);
//        Student2 newstudent = JSON.parseObject(json, Student2.class);
//        System.out.println(newstudent.age);


//        Child child = new Child();
//        child.newname = "xujixiao";
//        handle(child);
//        System.out.println(child.newname);

        Gson gson = new Gson();
        Student2 student2 = gson.fromJson(json, Student2.class);
        System.out.println(student2.age);

    }

    static class Student {
        public int age;
        public String name;
        public Boolean man;
    }
    static class Student2 {
        public int age;
        public String name;
        public boolean man;
    }


    static class Child extends Student{
        public String newname;
    }



    public static void handle(Student student){
        if (student instanceof Child) {
            Child child = (Child) student;
            child.newname = "zzzzz";
        }
    }
}
