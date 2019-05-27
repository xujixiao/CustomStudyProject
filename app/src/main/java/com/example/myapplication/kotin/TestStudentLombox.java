package com.example.myapplication.kotin;

import javax.xml.transform.Source;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * create by xujixiao on 2019-05-22 13:45
 */
@Data
@Accessors(chain = true)
public class TestStudentLombox {
    private String name;
    private String subName;
    private String age;

    public void testJVMName(){
        TestImp testImp = new TestImp();
        System.out.println(TestImp.showJvmName());

    }
}
