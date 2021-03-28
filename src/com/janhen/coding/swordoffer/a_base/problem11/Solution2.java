package com.janhen.coding.swordoffer.a_base.problem11;

// time:O(logN) space:O(1)
public class Solution2 {

    public int minNumberInRotateArray(int [] arr) {
        if (arr == null || arr.length == 0) return 0;

        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] == arr[lo] && arr[mid] == arr[hi])
                return getMin(arr, lo, hi);
            else if (arr[mid] <= arr[hi])    // [mid] in right small part
                hi = mid;
            else              // [mid] in left big part
                lo = mid + 1;
        }
        return arr[lo];
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
