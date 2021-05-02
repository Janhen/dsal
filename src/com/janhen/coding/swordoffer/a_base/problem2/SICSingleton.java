package com.janhen.coding.swordoffer.a_base.problem2;

/**
 * 静态内部类单例
 *
 * <pre>
 *   JDK5- 版本也可以保证线程安全
 *   JVM 对类的初始化锁控制
 * </pre>
 */
public class SICSingleton {
    private static class InnerClass{
        private static SICSingleton instance = new SICSingleton();
    }

    public static SICSingleton getInstance(){
        return InnerClass.instance;
    }

    private SICSingleton(){
        if(InnerClass.instance != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }
}
