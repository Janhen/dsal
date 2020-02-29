package com.janhen.swordoffer.recursiont_dp.problem42;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i ++) {
            curSum = curSum <= 0 ? arr[i] : curSum + arr[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
