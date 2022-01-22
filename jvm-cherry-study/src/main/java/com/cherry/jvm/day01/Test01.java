package com.cherry.jvm.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherry
 * @Date: 2021/4/13
 * @Desc: Test01
 */
public class Test01 {

    static class OOMTest{

    }

    public static void main(String[] args) {
        List<OOMTest> list = new ArrayList<>();
        while (true){
            OOMTest o = new OOMTest();
            list.add(o);
        }
    }
}
