package com.janhen.swordoffer.a_good.problem16;

public class SolutionB {

    // 无法处理 指数 exponent 小于1 的情况
    public double Power(double base, int exponent) {
        double res = 1.0;
        for (int i = 0; i <= exponent; i ++)
            res *= base;
        return res;
    }
}
