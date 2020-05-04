package main.java.janhen.leetcode.top100.other.solution49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            String sortStr = sort(strs[i]);
            if (!map.containsKey(sortStr))
                map.put(sortStr, new ArrayList<>());
            map.get(sortStr).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}