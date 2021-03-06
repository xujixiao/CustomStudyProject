package com.example.myapplication;

import com.example.myapplication.kotin.StudentKotlin;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Set;

/**
 * create by xujixiao on 2019/5/15 20:58
 */
public final class TestJsonParseTool {
    private TestJsonParseTool() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "xujixiao";
        student.age = 90;
        student.man = true;
        String json = new Gson().toJson(student);
        System.out.println(json);
        json = json.replace("90", "null");
        System.out.println(json);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "xujixiao");
        hashMap.put("age", "0");
        hashMap.put("man", true);
        json = new Gson().toJson(hashMap);
        System.out.println("hashmap解析的字符串是：" + json);
        Gson gson = new Gson();
        StudentKotlin student2 = gson.fromJson(json, StudentKotlin.class);
        System.out.println(student2.getAge());
        System.out.println(student2.getName());


        TestKotlinCotent testKotlinCotent = new TestKotlinCotent();
        testKotlinCotent.test();
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


    static class Child extends Student {
        public String newname;
    }


    /**
     * @param student
     */
    public static void handle(Student student) {
        if (student instanceof Child) {
            Child child = (Child) student;
            child.newname = "zzzzz";
        }
    }
}
