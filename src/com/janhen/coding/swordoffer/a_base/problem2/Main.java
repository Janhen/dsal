package com.janhen.coding.swordoffer.a_base.problem2;

import com.janhen.coding.swordoffer.a_base.problem2.v.ThreadLocalSingleton;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    /**
     * 基于 序列化 破坏单例
     */
    @Test 
    public  void testHungrySerialize() throws Exception {
        HungrySingleton instance = HungrySingleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton newInstance = (HungrySingleton) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }

    @Test
    public void testLazySingleton() throws Exception {
        Constructor c = LazySingleton.class.getDeclaredConstructor();
        c.setAccessible(true);
        LazySingleton o2 = (LazySingleton) c.newInstance();

        LazySingleton o1 = LazySingleton.getInstance();

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1 == o2);
    }


    @Test
    public void testEnumSerialize() throws Exception {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        EnumSingleton newInstance = (EnumSingleton) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());
    }

    @Test
    public void testEnumReflect() throws Exception {
        // IllegalArgumentException: Cannot reflectively create enum objects
        Constructor constructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingleton instance = (EnumSingleton) constructor.newInstance("Janhen",666);
    }


    @Test
    public void testDestroyDCSByReflection() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 类加载截断未初始化, 可以在未初始化前调用反射破坏单例
        Constructor c = DCLSingleton.class.getDeclaredConstructor();
        c.setAccessible(true);
        DCLSingleton o1 = (DCLSingleton) c.newInstance();

        DCLSingleton o2 = DCLSingleton.getInstance();
        System.out.println(o1 == o2);
    }

    @Test
    public void testDestorySICSByReflection() throws Exception {
        // 可防反射攻击: 类加载时已经创建好了对应的单例对象
        Constructor c = SICSingleton.class.getDeclaredConstructor();
        c.setAccessible(true);
        SICSingleton o1 = (SICSingleton) c.newInstance();

        SICSingleton o2 = SICSingleton.getInstance();
        System.out.println(o1 == o2);
    }

    @Test
    public void testThreadLocalInstance() throws InterruptedException {
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("program end");
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
        System.out.println("main thread"+ ThreadLocalSingleton.getInstance());
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();

            System.out.println(Thread.currentThread().getName()+"  "+instance);
        }
    }
}
