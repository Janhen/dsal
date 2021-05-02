package com.janhen.coding.swordoffer.a_base.problem11;

public class Solution {
    public int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == arr[lo] && arr[mid] == arr[hi]) {
                return getMin(arr, lo, hi);
            } else if (arr[mid] <= arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo];
    }

    // case1: [1,1,3,1]
    // case2: [1,1,0,1]
    // case3: [1,1,1,1]
    private int getMin(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (arr[i] < arr[lo]) {
                return arr[i];
            }
        }
        return arr[lo];
    }
}
