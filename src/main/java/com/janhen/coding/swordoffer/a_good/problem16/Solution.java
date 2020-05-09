package com.janhen.coding.swordoffer.a_good.problem16;

public class Solution {

    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        boolean isNegative = exponent < 0;
        exponent = isNegative ? - exponent : exponent;

        double pow = Power(base, exponent / 2);
        pow = exponent % 2 != 0 ? pow*pow*base : pow*pow;

        return isNegative ? 1.0 / pow : pow;
    }
}
