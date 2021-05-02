package com.janhen.coding.swordoffer.a_base.problem10;

public class Solution {
    private int[] fib = new int[40];

    public Solution() {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public int Fibonacci(int n) {
        return fib[n];
    }
}
