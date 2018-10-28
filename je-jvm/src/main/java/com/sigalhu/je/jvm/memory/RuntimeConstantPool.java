package com.sigalhu.je.jvm.memory;

/**
 * @author huxujun
 * @date 2018/10/28
 */
public class RuntimeConstantPool {

    /**
     * 判断str1+str2所表示的字符串是否位于常量池外
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean outOfConstantPool(String str1, String str2) {
        //由StringBuilder创建的字符串实例在java堆上
        String str = new StringBuilder(str1).append(str2).toString();
        //在jdk1.6中，intern()方法会把首次遇到的字符串实例复制到常量池中，并返回常量池中该字符串的实例的引用
        //而jdk1.7的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，
        // 因此intern()返回的引用和由StringBuilder创建的那个字符串实例是同一个
        return str.intern() == str;
    }
}
