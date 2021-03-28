package com.janhen.coding.leetcode.ds.hashtable.practice.solution290;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }
    // char1 -> char2
    BiMap<Character, String> map = new BiMap();
    for (int i = 0; i < pattern.length(); i++) {
      if (!map.put(pattern.charAt(i), words[i]))
        return false;
    }
    return true;
  }


  class BiMap<K, V> {
    private Map<K, V> map = new HashMap<>();

    public V get(K key) {
      return map.get(key);
    }

    // is unique
    public boolean put(K key, V val) {
      if (map.containsKey(key)) {
        if (!map.get(key).equals(val))
          return false;
      } else {
        if (map.containsValue(val))
          return false;
        map.put(key, val);
      }
      return true;
    }
  }
}