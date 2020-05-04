package main.java.janhen.swordoffer.a_base.problem2.v;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器单例
 *
 * <pre>
 *   类似 Spring IOC 容器存取
 * </pre>
 *
 * @author Janhen
 */
public class ContainerSingleton {

    private ContainerSingleton() {}

    private static Map<String,Object> singletonMap = new HashMap<String,Object>();

    public static void putInstance(String key,Object instance){
        if(!key.trim().equals("") && instance != null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }
}
