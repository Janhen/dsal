package com.janhen.design.oneToOneMap;

import java.util.HashMap;
import java.util.Map;

class OneToOneMap<K, V> {
  private Map<K, V> map = new HashMap<>();

  public V get(K key) {
    return map.get(key);
  }

  public boolean put(K key, V val) {
    if (map.containsKey(key)) {
      if (!map.get(key).equals(val))
        return false;
    } else {
      // O(n)
      if (map.containsValue(val))
        return false;
      map.put(key, val);
    }
    return true;
  }
}