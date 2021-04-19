package com.janhen.coding.leetcode.ds.hashtable.practice.solution290;

//  290. Word Pattern
// https://leetcode.com/problems/word-pattern/
// Easy
// Hash Table

/*
判断单词是否与指定模式匹配
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution2$ {

    // 1 ms, faster than 99.28%
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length)
            return false;
        OneToOneMap<Character, String> map = new OneToOneMap();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.put(pattern.charAt(i), words[i]))
                return false;
        }
        return true;
    }


    class OneToOneMap<K, V> {
        Map<K, Integer> map1 = new HashMap<>();
        Map<V, Integer> map2 = new HashMap<>();
        int sequence;

        public boolean put(K key, V val) {
            if (!Objects.equals(map1.put(key, sequence), map2.put(val, sequence)))
                return false;
            sequence++;
            return true;
        }

        public V get(K key) {
            return null;
        }
    }
//    class OneToOneMap<K, V> {
//        Map<Holder<K>, Holder<V>> map = new HashMap<>();
//        int sequence;
//
//        public boolean put(K key, V val) {
//            Holder<K> k = new Holder<>(key, sequence);
//            Holder<V> v = new Holder<>(val, sequence);
//            if (map.containsKey(k)) {
//                if (map.get(k).index != v.index) {
//                    return false;
//                }
//            } else {
//                Pair
//            }
//
//
//
//            if (!Objects.equals(map1.put(key, sequence), map2.put(val, sequence)))
//                return false;
//            sequence ++;
//            return true;
//        }
//
//        public V get(K key) {
//            return null;
//        }
//
//        class Holder<E> {
//            E val;
//            int index;
//            public Holder(E val, int index) {
//                this.val = val;
//                this.index = index;
//            }
//        }
//    }
}