package com.janhen.coding.swordoffer.a_base.problem2;

/**
 * 锁住方法或锁住代码块
 *
 * <pre>
 *   synchronized 保证线程安全
 * </pre>
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
        if (instance != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
