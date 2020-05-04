package main.java.janhen.swordoffer.a_good.problem16;

public class Solution2 {

    // 一般式
    // 考虑：
    //  - 指数为负数的情况；
    //  - 底数为0
    public double Power(double base, int exponent) {
        if (base == 0)  return 0.0;
        if (exponent == 1) return base;

        double res = 0.0;
        if (exponent < 0) res = 1.0 / PowerCore(base, -exponent);
        else res = PowerCore(base, exponent);

        return res;
    }

    private double PowerCore(double base, int exp) {
        double res = 1.0;
        for (int i = 0; i < exp; i++)
            res = res * base;
        return res;
    }
}
