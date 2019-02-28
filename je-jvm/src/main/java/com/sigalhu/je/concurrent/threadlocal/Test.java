package com.sigalhu.je.concurrent.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huxujun
 * @date 2019/1/31
 */
public class Test {

    public static TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
    private static ExecutorService executor = Executors.newFixedThreadPool(1);
    private static ExecutorService ttlExecutor = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws Exception {
        System.err.println("主线程开启。。。");

        threadLocal.set("主线程赋值1");
        ttlExecutor.submit(Test::printThreadLocal);
        executor.submit(Test::submit);
        Thread.sleep(1000);

        threadLocal.set("主线程赋值2");
        ttlExecutor.submit(Test::printThreadLocal);
        executor.submit(Test::submit);
        Thread.sleep(1000);

        System.err.println("主线程结束。。。");
        ttlExecutor.shutdown();
        executor.shutdown();
    }

    private static void submit() {
        printThreadLocal();
        ttlExecutor.submit(Test::printThreadLocal);
        threadLocal.remove();
    }

    private static void printThreadLocal() {
        System.err.println(Thread.currentThread().getName() + " 子线程开启。。。");
        System.err.println(Thread.currentThread().getName() + " 子线程获取本地变量值: " + threadLocal.get());
        System.err.println(Thread.currentThread().getName() + " 子线程关闭。。。");
    }
}
