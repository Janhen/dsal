package com.janhen.coding.leetcode.leetcode.solution387;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    // LinkedHashMap + set
    //  keep add order
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (map.containsKey(c))    // two contains Synchronous operation can omit
                    map.remove(c);
            } else {
                set.add(c);
                map.put(c, i);
            }
        }
        return map.isEmpty() ? -1 : map.entrySet().iterator().next().getValue();
    }
}
