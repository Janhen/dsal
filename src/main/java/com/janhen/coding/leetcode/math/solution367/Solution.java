package com.janhen.coding.leetcode.math.solution367;

class Solution {
    // (x+1)^2-x^2 = 2x + 1
    // 1, 4, 9, 16, ...
    //   3, 5, 7, ...
    public boolean isPerfectSquare(int num) {
        int sum = 1;
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }
}