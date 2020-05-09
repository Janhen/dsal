package com.janhen.coding.swordoffer.recursiont_dp.problem48;

// 48. 最长不含重复字符的子字符串

public class Solution2 {

    public int longestSubStringWithoutDuplication(String str) {
        int maxLen = 0;            // "" return to return
        int L = 0, R = -1;        // [L, R] is window
        int[] freq = new int[256];   // record window to maintain [L,R] is all distinct
        while (L < str.length()) {
            if (R+ 1< str.length() && freq[str.charAt(R + 1)] == 0) // [R] not occur before
                freq[str.charAt(++ R)] ++;
            else                                // [R] not have OR [R] is duplication
                freq[str.charAt(L ++)] --;
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
}
