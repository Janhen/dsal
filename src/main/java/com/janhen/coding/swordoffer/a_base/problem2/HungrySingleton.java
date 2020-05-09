package com.janhen.coding.swordoffer.a_base.problem2;

import java.io.Serializable;

/**
 * 饿汉式单例
 *
 * <pre>
 *   私有构造+反射防御
 *   序列化防御(重写readResolve)
 * </pre>
 *
 * @author Janhen
 */
public class HungrySingleton implements Serializable,Cloneable{

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    private HungrySingleton(){
        if(hungrySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    private Object readResolve(){
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
