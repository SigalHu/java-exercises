package com.sigalhu.je.jvm.cacheline;

import java.util.Random;

/**
 * @author huxujun
 * @date 2020/6/28
 */
public class CacheLineVictim {

    public static void main(String[] args) {
        Random rnd = new Random(0);
        long[][] array = new long[10000000][8];
        for (long[] longs : array) {
            for (int ii = 0; ii < longs.length; ii++) {
                longs[ii] = rnd.nextLong();
            }
        }

        long sum = 0, start;
        start = System.nanoTime();
        for (int ii = 0; ii < 10000000; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                sum += array[ii][jj];
            }
        }
        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);

        start = System.nanoTime();
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 10000000; jj++) {
                sum += array[jj][ii];
            }
        }
        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);
    }
}
