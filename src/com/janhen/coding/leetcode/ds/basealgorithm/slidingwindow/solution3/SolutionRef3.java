package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution3;// 3. Longest Substring Without Repeating Characters

import java.util.Arrays;

public class SolutionRef3 {

    // sliding window or dynamic programming
    // time: O(len(s))
    // space: O(len(charset))
    public int lengthOfLongestSubstring(String s) {

        int[] last = new int[256];
        Arrays.fill(last, -1);

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;
        while(r + 1 < s.length()){
            r ++;
            if(last[s.charAt(r)] != -1)                // 之前出现过
                l = Math.max(l, last[s.charAt(r)] + 1);          // through right edge come to condition, then insure left edge
            res = Math.max(res, r - l + 1);
            last[s.charAt(r)] = r;             // record last appear position
        }
        return res;
    }
}
