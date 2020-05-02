package com.janhen.design.oneToOneMap;

import java.util.HashMap;
import java.util.Map;

class OneToOneMap2<K, V> {

  Map<K, Integer> map1 = new HashMap<>();
  Map<V, Integer> map2 = new HashMap<>();
  int sequence;

  // O(1)
  public boolean put(K key, V val) {
    if (!map1.put(key, sequence).equals(map2.put(val, sequence)))
      return false;
    sequence++;
    return true;
  }
}