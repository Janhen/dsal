package com.janhen.coding.swordoffer.a_base.problem2;

/**
 * 双重检测锁单例
 * - volatile 声明 instance 保证程序的可见性
 * - getInstance 判断两次 instance 为空
 * - 私有化构造器
 *
 * <p>
 * Object obj = new Object():
 * 1.分配内存给这个对象
 * 2.初始化对象
 * 3.obj 指向刚分配的内存地址
 */
public class DCLSingleton {
    // volatile 保证程序可见性
    private volatile static DCLSingleton instance = null;

    // 私有化构造器
    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            // 双重检测锁避免并发访问
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
