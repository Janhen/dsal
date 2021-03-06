package com.janhen.coding.swordoffer.a_good.problem16;

public class Solution2 {
    // 考虑：
    //  - 特殊情况： 底数为 0，指数为 1
    //  - 指数为负数的情况
    //  - 底数为0
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0.0;
        }
        if (exponent == 1) {
            return base;
        }

        double res = 0.0;
        if (exponent < 0) {
            res = 1.0 / PowerCore(base, -exponent);
        } else {
            res = PowerCore(base, exponent);
        }

        return res;
    }

    private double PowerCore(double base, int exp) {
        double res = 1.0;
        for (int i = 0; i < exp; i++) {
            res = res * base;
        }
        return res;
    }
}
