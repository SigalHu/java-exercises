package com.sigalhu.je.jvm.assembly;

/**
 * @author huxujun
 * @date 2020/6/6
 */
public class VolatileTest {
    public long sum = 0;

    public synchronized int add(int a, int b) {
        int temp = a + b;
        sum += temp;
        return temp;
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();

        int sum = 0;

        for (int i = 0; i < 1000000; i++) {
            sum = test.add(sum, 1);
        }

        System.out.println("Sum:" + sum);
        System.out.println("Test.sum:" + test.sum);
    }
}
