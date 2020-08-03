package com.sigalhu.je.jvm.classloading;

/**
 * @author huxujun
 * @date 2020/7/20
 */
public class ConstClassTest {

    public static void main(String[] args) throws InterruptedException {
        System.err.println(ConstClass.HELLO_WORLD);
        System.err.println("====================");
        System.err.println(ConstClass.VALUE);
    }
}