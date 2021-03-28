package com.janhen.coding.swordoffer.a_base.problem15;

public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt ++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
