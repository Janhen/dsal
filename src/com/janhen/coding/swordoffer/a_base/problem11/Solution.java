package com.janhen.swordoffer.a_base.problem11;

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;

        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == array[lo] && array[mid] == array[hi]) {
                return getMin(array, lo, hi);
            } else if (array[mid] <= array[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return array[lo];
    }

    private int getMin(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (arr[i] < arr[lo]) {
                return arr[i];
            }
        }
        return arr[lo];
    }
}
