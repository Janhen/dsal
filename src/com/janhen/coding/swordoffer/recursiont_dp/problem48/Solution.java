package com.janhen.swordoffer.recursiont_dp.problem48;

// 48. 最长不含重复字符的子字符串

import java.util.Arrays;

public class Solution {

    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] position = new int[26];           // record last occur position, override to implement
        Arrays.fill(position, -1);
        for (int i = 0; i < str.length(); i ++) {
            int c = str.charAt(i) - 'a';
            int preI = position[c];
            if (preI == -1 || (i - preI) > curLen) {    // not occur OR not in cur sub array
                curLen = curLen + 1;
                maxLen = Math.max(curLen, maxLen);
            } else {
                curLen = i - preI;
                maxLen = Math.max(curLen, maxLen);
            }
            position[c] = i;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
