package com.janhen.coding.leetcode.ds.bit.solution231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
