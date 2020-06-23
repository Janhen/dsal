package com.janhen.coding.leetcode.ds.hashtable.practice.solution205;

//  205. Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/

import java.util.HashMap;
import java.util.Map;

/*
 * 自定义结构
 */
class Solution2_ {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        OneToOneMap oneToOneMap = new OneToOneMap();
        for (int i = 0; i < s.length(); i ++) {
            if (!oneToOneMap.put(s.charAt(i), t.charAt(i)))
                return false;
        }
        return true;
    }
 
    class OneToOneMap {
        private Map<Character, Character> map = new HashMap<>();

        public char get(char key) {
            return map.get(key);
        }

        // is unique
        public boolean put(char key, char val) {
            if (map.containsKey(key)) {
                if (map.get(key) != val)
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