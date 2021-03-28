package com.janhen.coding.swordoffer.a_base.problem15_3;

public class Solution {
    public int getDifferentCount(int m, int n) {
        int xor = m ^ n;
        int cnt = 0;
        while (xor != 0) {
            cnt ++;
            xor = xor & (xor-1);
        }
        return cnt;
    }
}
