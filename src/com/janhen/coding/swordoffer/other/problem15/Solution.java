package com.janhen.coding.swordoffer.other.problem15;

public class Solution {
    // 数学类问题
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt ++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
