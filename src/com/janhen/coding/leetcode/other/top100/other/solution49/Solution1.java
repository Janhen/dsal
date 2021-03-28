package com.janhen.coding.leetcode.other.top100.other.solution49;

import java.util.*;

class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();
        String[] sortStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i ++)
            sortStrs[i] = sort(strs[i]);

        for (int i = 0; i < strs.length; i ++) {
            if (!map.containsKey(sortStrs[i]))
                map.put(sortStrs[i], new ArrayList<>());
            map.get(sortStrs[i]).add(strs[i]);
        }
        res.addAll(map.values());
        return res;
    }

    private String sort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}
