package com.janhen.leetcode.top100.other.solution76;

// 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;
import java.util.Map;

//  22 ms, faster than 59.16%
class SolutionCom1 {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : t.toCharArray())
            freq.put(c, freq.getOrDefault(c,0) + 1);
        int counter = t.length();          // 记录待匹配字符的总个数

        int L = 0, R = 0;
        int fromIndex = 0;
        int minLen = Integer.MAX_VALUE;
        while(R < s.length()){
            char rCh = s.charAt(R);
            if (freq.containsKey(rCh)) {    // [R] in match
                if (freq.get(rCh) > 0)       // [R] have remain to match
                    counter --;
                freq.put(rCh, freq.get(rCh)-1);
            }
            R ++;

            while(counter == 0){
                if(R-L < minLen){
                    minLen = R - L;
                    fromIndex = L;
                }
                char lCh = s.charAt(L);
                if(freq.containsKey(lCh)){       // [L] in match
                    if (freq.get(lCh) == 0)        // [L]
                         counter ++;
                    freq.put(lCh, freq.get(lCh) + 1);
                }
                L ++;
            }
        }
        return minLen == Integer.MAX_VALUE ?  "" : s.substring(fromIndex, fromIndex+minLen);
    }
}