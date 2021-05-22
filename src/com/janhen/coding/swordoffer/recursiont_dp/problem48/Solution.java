package com.janhen.coding.swordoffer.recursiont_dp.problem48;

// 48. 最长不含重复字符的子字符串

public class Solution {
    // 滑动窗口计算, 构造一个窗口，窗口里面的元素都是不重复的
    public int lengthOfLongestSubstring(String s) {
        // record sliding window freq
        int[] freqs = new int[256];
        int L = 0;
        int R = -1;
        // default is 0 for ""
        int maxLen = 0;
        while (L < s.length()) {
            // window edge
            if (R + 1 < s.length() && freqs[s.charAt(R + 1)] == 0) {
                char rCh = s.charAt(R + 1);
                freqs[rCh]++;
                R++;// in window
            } else {
                char lCh = s.charAt(L);
                freqs[lCh]--;
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
}
