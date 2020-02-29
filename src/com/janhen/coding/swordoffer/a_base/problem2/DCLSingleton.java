package com.janhen.swordoffer.a_base.problem2;

/**
 * 双重检测锁单例
 *
 * Object obj = new Object():
 *  1.分配内存给这个对象
 *  2.初始化对象
 *  3.obj 指向刚分配的内存地址
 *
 * @author Janhen
 */
public class DCLSingleton {
    private volatile static DCLSingleton DCLSingleton = null;

    private DCLSingleton(){}

    public static DCLSingleton getInstance(){
        if(DCLSingleton == null){
            synchronized (DCLSingleton.class){
                if(DCLSingleton == null){
                    DCLSingleton = new DCLSingleton();
                }
            }
        }
        return DCLSingleton;
    }
}
