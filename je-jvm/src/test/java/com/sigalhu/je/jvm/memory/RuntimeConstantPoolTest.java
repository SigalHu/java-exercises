package com.sigalhu.je.jvm.memory;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huxujun
 * @date 2018/10/28
 */
public class RuntimeConstantPoolTest {

    @Test
    public void outOfConstantPool() {
        //常量池中包括：计算、机、软件
        Assert.assertTrue(RuntimeConstantPool.outOfConstantPool(new StringBuilder("计算").append("机").toString(), "软件"));
        //常量池中包括：计算、机、软件、计算机软件、计、算
        Assert.assertFalse(RuntimeConstantPool.outOfConstantPool("计", "算"));
        //常量池中包括：计算、机、软件、计算机软件、计、算
        Assert.assertTrue(RuntimeConstantPool.outOfConstantPool("计算", "机"));
        //常量池中包括：计算、机、软件、计算机软件、计、算、计算机、机软件
        Assert.assertFalse(RuntimeConstantPool.outOfConstantPool("计算", "机软件"));
        //常量池中包括：计算、机、软件、计算机软件、计、算、计算机、机软件、软、件
        Assert.assertFalse(RuntimeConstantPool.outOfConstantPool("软", "件"));
    }
}