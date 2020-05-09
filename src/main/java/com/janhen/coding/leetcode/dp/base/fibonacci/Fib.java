package com.janhen.coding.leetcode.dp.base.fibonacci;

import org.junit.Test;

import java.util.Arrays;

public class Fib {

    static int count;           /* 记录函数调用次数 */

    static int[] memo;

    // time : O(2^n)
    static long fib(int n) {
        count ++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }

    // The search of memory
    // top to down
    // time : O(n)
    static int fib2(int n) {
        count ++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (memo[n] == -1)
            memo[n] = fib2(n - 1) + fib2(n - 2);

        return memo[n];
    }

    // down to top
    static int fib3(int n) {
        count ++;
        int[] memo = new int[n +1];
        memo[0] = 0;
        memo[1] = 1;                             /* 记录最基本的问题解 */
        for (int i = 2; i <= n; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];      /* 根据之前问题的解求出更大子问题的解 */
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 33;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);


        long start = System.nanoTime();
        System.out.println(fib2(33));
        System.out.println("count : " + count);
        long end = System.nanoTime();

        System.out.println("Run : " + (end - start) / 1E9 + "s");
    }

    @Test
    public void testRecursion() {
        int n = 20;

        long start = System.nanoTime();
        System.out.println(fib(n));
        System.out.println("count : " + count);
        long end = System.nanoTime();

        System.out.println("Run : " + (end - start) / 1E9 + "s");
    }

    @Test
    public void testSearchOfMemo() {
        int n = 1000;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        long start = System.nanoTime();
        System.out.println(fib2(n));
        System.out.println("count : " + count);
        long end = System.nanoTime();
        System.out.println("Run : " + (end - start) / 1E9 + "s");
    }

    @Test
    public void testDP() {
        int n = 1000;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        long start = System.nanoTime();
        System.out.println(fib3(n));
        System.out.println("count : " + count);
        long end = System.nanoTime();
        System.out.println("Run : " + (end - start) / 1E9 + "s");
    }
}
