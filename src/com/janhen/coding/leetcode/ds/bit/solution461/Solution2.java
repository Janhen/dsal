package com.janhen.coding.leetcode.ds.bit.solution461;

class Solution2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            cnt ++;
        }
        return cnt;
    }
}