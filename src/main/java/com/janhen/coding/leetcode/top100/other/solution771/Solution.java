package com.janhen.coding.leetcode.top100.other.solution771;

import java.util.Set;
import java.util.stream.Collectors;

// O(n)
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> record = J.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        int cnt = 0;
        for (char c : S.toCharArray())
            if (record.contains(c))
                cnt ++;
        return cnt;
    }
}