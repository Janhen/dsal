package com.janhen.coding.leetcode.ds.bit.solution342;

public class Solution2 {
    // 正则表达式匹配
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
