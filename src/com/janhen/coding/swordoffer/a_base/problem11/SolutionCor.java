package com.janhen.coding.swordoffer.a_base.problem11;

/**
 * 关联问题: 数组中不含有重复元素的旋转数组最小数字
 */
public class SolutionCor {

    public int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] <= arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo];
    }
}
