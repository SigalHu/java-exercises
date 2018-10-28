package com.sigalhu.je.jvm.gc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huxujun
 * @date 2018/10/28
 */
public class FinalizeEscapeGCTest {

    @Test
    public void test() throws Exception {
        FinalizeEscapeGC.SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        FinalizeEscapeGC.SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        Assert.assertNotNull(FinalizeEscapeGC.SAVE_HOOK);

        //下面这段代码与上面的完全相同，但这次自救却失败了
        FinalizeEscapeGC.SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        Assert.assertNull(FinalizeEscapeGC.SAVE_HOOK);
    }
}