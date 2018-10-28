package com.sigalhu.je.jvm.gc;

/**
 * 如果对象在进行可达性分析后发现没有与GC Roots相连接的引用链，那它将会被第一次标记并且进行一次筛选，
 * 筛选的条件是此对象是否有必要执行finalize()方法。当对象没有覆盖finalize()方法，或者finalize()方法已经被虚拟机调用过，
 * 虚拟机将这两种情况都视为“没有必要执行”，即意味着直接回收。
 *
 * 如果这个对象被判定为有必要执行finalize()方法，那么这个对象将会放置在一个叫做F-Queue的队列之中，
 * 并在稍后由一个由虚拟机自动建立的、低优先级的Finalizer线程去执行它。这里所谓的"执行"是指虚拟机会触发这个方法，
 * 但并不承诺会等待它运行结束，这样做的原因是,如果一个对象在finalize()方法中执行缓慢，或者发生了死循环(更极端的情况)，
 * 将很可能会导致F-Queue队列中其他对象永久处于等待，甚至导致整个内存回收系统崩溃。
 *
 * finalize()方法是对象逃脱死亡命运的最后一次机会，稍后GC将对F-Queue中的对象进行第二次小规模的标记，
 * 如果对象要在finalize()中成功拯救自己——只要重新与引用链上的任何一个对象建立关联即可，譬如把自己(this关键字)
 * 赋值给某个类变量或者对象的成员变量，那在第二次标记时它将被移除出“即将回收”的集合；如果对象这时候还没有逃脱，
 * 那基本上它就真的被回收了，但这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次。
 *
 * @author huxujun
 * @date 2018/10/28
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        SAVE_HOOK = this;
    }
}
