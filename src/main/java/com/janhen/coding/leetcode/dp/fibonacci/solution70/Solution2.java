package com.janhen.coding.leetcode.dp.fibonacci.solution70;

class Solution2 {

    private int[] record;

    public Solution2() {
        record = new int[41];
        record[1] = 1;
        record[2] = 2;
        for (int i = 3; i <= 40; i ++)
            record[i] = record[i - 1] + record[i - 2];
    }

    public int climbStairs(int n) {
        return record[n];
    }
}