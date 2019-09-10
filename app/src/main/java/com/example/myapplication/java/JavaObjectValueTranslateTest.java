package com.example.myapplication.java;

/**
 * create by xujixiao on 2019-06-06 10:39
 */
public class JavaObjectValueTranslateTest {
    /**
     *
     * @param args  参数
     */
    public static void main(String[] args) {
        System.out.println("test");
        int a = 0;
        changeValue(a);
        System.out.println(a);

        String first = "zhang";
        changeStringValue(first);
        System.out.println(first);
    }

    public static void changeValue(int value) {
        value = 2;
    }


    public static void changeStringValue(String value) {
        value = "test";
    }

}
