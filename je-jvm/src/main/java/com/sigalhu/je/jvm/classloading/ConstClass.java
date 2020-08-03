package com.sigalhu.je.jvm.classloading;

/**
 * @author huxujun
 * @date 2020/7/20
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "hello world";
    public static final int VALUE = 123;
}
