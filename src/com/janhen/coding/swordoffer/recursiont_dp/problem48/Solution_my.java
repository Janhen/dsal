package com.janhen.coding.swordoffer.recursiont_dp.problem48;

public class Solution_my {
    public int lengthOfLongestSubstring(String str) {
        int maxLen = 0;
        int L = 0, R = -1;             // define this can narrow AND can extend
        int[] freqs = new int[256];
        while (L < str.length()) {     // narrow L edge, need remove L
            if (R + 1 < str.length() && freqs[str.charAt(R + 1)] == 0) {    // [R+1] never occur before, extend R edge need add R
                freqs[str.charAt(R + 1)] ++;               // this is char not int
                R ++;
            } else {
                freqs[str.charAt(L)] --;            // narrow
                L ++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
}
