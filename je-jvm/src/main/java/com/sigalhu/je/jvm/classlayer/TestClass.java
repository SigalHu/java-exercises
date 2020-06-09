package com.sigalhu.je.jvm.classlayer;

import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;

/**
 * @author huxujun
 * @date 2020/4/27
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.print(ClassLayout.parseClass(HashMap.class).toPrintable());
        System.out.println();
        System.out.print(ClassLayout.parseClass(HashMap.Entry.class).toPrintable());
        System.out.println();
        System.out.print(ClassLayout.parseClass(String.class).toPrintable());
        System.out.println();
        System.out.print(ClassLayout.parseClass(Long.class).toPrintable());

        String a = "a";
        // \u000da = "b";
        System.err.println(a);
    }
}
