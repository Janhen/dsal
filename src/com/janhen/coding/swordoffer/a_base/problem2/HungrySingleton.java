package com.janhen.coding.swordoffer.a_base.problem2;

import java.io.Serializable;

/**
 * 饿汉式单例： 类初始化的时候就创建好单例对象
 *
 * <pre>
 *   私有构造+反射防御
 *   序列化防御(重写 readResolve)
 * </pre>
 */
public class HungrySingleton implements Serializable, Cloneable {
    // new object before invoke
    private final static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    private HungrySingleton() {
        if (instance != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    private Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
