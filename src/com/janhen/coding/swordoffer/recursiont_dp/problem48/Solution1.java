package com.janhen.coding.swordoffer.recursiont_dp.problem48;

// 48. 最长不含重复字符的子字符串

import java.util.Arrays;

public class Solution1 {
    //         f(i-1) + 1; 当前[i]之前未出现过                            对应 V3
    //
    // f(i) =  diff;             diff < f(i-1),当前元素出现在表示f(i-1)中；      对应 V1
    //
    //         f(i-1) + 1;  当前元素在前面出现过但未在f(i-1)表示的子字符中， 对应 V2
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        // value -> index
        int[] position = new int[26];           // record last occur position, override to implement
        Arrays.fill(position, -1);
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            int preIdx = position[c];
            if (preIdx == -1 || (i - preIdx) > curLen) {    // not occur OR not in cur sub array
                curLen = curLen + 1;
                maxLen = Math.max(curLen, maxLen);
            } else {
                curLen = i - preIdx;
                maxLen = Math.max(curLen, maxLen);
            }
            position[c] = i;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
