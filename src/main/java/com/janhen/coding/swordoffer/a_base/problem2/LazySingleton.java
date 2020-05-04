package main.java.janhen.swordoffer.a_base.problem2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 锁住方法或锁住代码块
 *
 * <pre>
 *   synchronized 保证线程安全
 * </pre>
 *
 * @author Janhen
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton(){
        if(lazySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Constructor c = LazySingleton.class.getDeclaredConstructor();
        c.setAccessible(true);
        LazySingleton o2 = (LazySingleton) c.newInstance();

        LazySingleton o1 = LazySingleton.getInstance();

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1==o2);
    }
}
