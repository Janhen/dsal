package com.janhen.coding.swordoffer.recursiont_dp.problem42;

public class Solution {
    // F(i): 以 array[i] 为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
    // f(i) =  arr[i]           ;     i = 0  or f(i - 1) < 0
    //         f(i - 1) + arr[i];     f(i - 1) > 0;
    //
    // ==> f(i) = max(val, f(i-1)+val)
    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 当前累计和，可被负数截断
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i ++) {
            curSum = curSum <= 0 ? arr[i] : curSum + arr[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
