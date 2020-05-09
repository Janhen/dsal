package com.janhen.coding.swordoffer.a_base.problem2.v;

/**
 * 线程本地单例
 *
 * <pre>
 *   ThreadLocal.initialValue() 设置初始值
 *   每个线程都创建一个, 在未设值的情况下默认都返回该初始值.
 * </pre>
 *
 * @author Janhen
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstanceThreadLocal
             = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstanceThreadLocal.get();
    }
}
