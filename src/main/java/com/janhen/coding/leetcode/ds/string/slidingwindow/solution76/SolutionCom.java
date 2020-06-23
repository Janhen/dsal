package com.janhen.coding.leetcode.ds.string.slidingwindow.solution76;

// 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;
import java.util.Map;

class SolutionCom {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : t.toCharArray())
            freq.put(c, freq.getOrDefault(c,0) + 1);
        int counter = freq.size();          // 记录不同字符的个数

        int L = 0, R = 0;
        int fromIndex = 0;
        int minLen = Integer.MAX_VALUE;
        while(R < s.length()){
            char rCh = s.charAt(R);
            if (freq.containsKey(rCh)) {
                freq.put(rCh, freq.get(rCh)-1);
                if(freq.get(rCh) == 0) counter --;
            }
            R ++;

            while(counter == 0){
                char lCh = s.charAt(L);
                if(freq.containsKey(lCh)){
                    freq.put(lCh, freq.get(lCh) + 1);
                    if(freq.get(lCh) > 0) counter++;
                }
                if(R-L < minLen){
                    minLen = R - L;
                    fromIndex = L;
                }
                L++;
            }
        }
        return minLen == Integer.MAX_VALUE ?  "" : s.substring(fromIndex, fromIndex+minLen);
    }
}