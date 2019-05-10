package com.example.myplugin;

/**
 * create by xujixiao on 2019/5/10 09:53
 */
public class ValueTestClass {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "zhangkp";
//        System.out.println(student.name);
//        setName(student);
//        System.out.println(student.toString());
//        System.out.println("-------------");

        setNameObject(student);
        System.out.println(student.toString());
    }

    public static void setName(Student student) {
        student.name = "xujixiao";
        System.out.println("student = [" + student + "]");
    }

    public static void setNameObject(Student student) {
        student = new Student();
        student.name = "gulina";
        System.out.println(student.name);
    }

    static class Student {
        public String name;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
