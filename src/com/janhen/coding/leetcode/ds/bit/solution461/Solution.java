package com.janhen.coding.leetcode.ds.bit.solution461;

class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        int flag = 1;
        while (flag <= 32) {
            int xBit = numOfnthBit(x, flag);
            int yBit = numOfnthBit(y, flag);
            if (xBit != yBit)
                cnt ++;
            flag ++;
        }
        return cnt;
    }

    public int numOfnthBit(int num, int n) {
        return num & (1 << n);
    }
}