package com.janhen.coding.leetcode.ds.hashtable.practice.solution205;

import java.util.HashMap;
import java.util.Map;

/*
 * 11 ms, faster than 52.90%
 * 一对一映射   y = f(x) ⇔ x = g(y)    x, y only sure
 * foo, bar
 * f -> b
 * o -> a
 * o -> r error
 * ab, aa
 * a -> a      反向映射 ⇒  a -> a
 * b -> a              ⇒  a -> b
 */
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (record.containsKey(s.charAt(i))) {
                if (record.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (record.containsValue(t.charAt(i)))
                    return false;
                record.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}