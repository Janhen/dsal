package com.janhen.structures.design.onetoonemap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 两个 Map，分别保存 key 和 val，使用一个 sequence 来唯一确定是否相等
 *
 * @param <K>
 * @param <V>
 */
class OneToOneMap2<K, V> {
    private final Map<K, Integer> map1 = new HashMap<>();
    private final Map<V, Integer> map2 = new HashMap<>();
    private int sequence;

    // O(1)
    public boolean put(K key, V val) {
        Integer keyReplace = map1.put(key, sequence);
        Integer valReplace = map2.put(val, sequence);
        if (Objects.equals(keyReplace, valReplace) == false) {
            return false;
        }
        sequence++;
        return true;
    }
}