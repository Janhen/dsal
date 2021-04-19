package com.janhen.coding.util;

public class MathHelper {
    /**
     * 最大公约数
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 最小公倍数
     */
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 每位的平方和
     */
    public int digitSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
