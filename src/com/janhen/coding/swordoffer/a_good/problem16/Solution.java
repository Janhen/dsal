package com.janhen.coding.swordoffer.a_good.problem16;

public class Solution {
    // 自定义
    // x^n = x^(n/2) * x^(n/2)        x%2==0
    // x^(n/2) * x^(n/2) * x    x%2==1
    public double Power(double base, int exponent) {
        // special input handle
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        // record special ..
        boolean isNegative = exponent < 0;
        exponent = isNegative ? -exponent : exponent;

        // recursive half ...
        double halfPow = Power(base, exponent / 2);
        double pow = exponent % 2 != 0 ? halfPow * halfPow * base : halfPow * halfPow;

        return isNegative ? 1.0 / pow : pow;
    }
}
