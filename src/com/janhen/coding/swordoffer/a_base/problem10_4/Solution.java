package com.janhen.swordoffer.a_base.problem10_4;

public class Solution {

    public int RectCover(int target) {
        if (target <= 2) return target;
        int pre1 = 2, pre2 = 1;
        int res = 0;
        for (int i = 3; i <= target; i++) {     // i == 3; i <= target        ==      i = 2; i <= target
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
