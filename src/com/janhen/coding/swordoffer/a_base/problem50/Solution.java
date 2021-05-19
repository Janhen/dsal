package com.janhen.coding.swordoffer.a_base.problem50;

public class Solution {
    // time: O(N), space: O(N)
    public int FirstNotRepeatingChar(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        // iterate from original order
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
