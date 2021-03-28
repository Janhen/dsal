package com.janhen.coding.swordoffer.a_base.problem11;

// 11 旋转数组的最小数字

public class SolutionCor2 {
/*
    // Binary Search: 数组中不含有重复元素
    public int minNumberIndexInRotateArray(int [] arr) {
        if (arr == null || arr.length == 0) return 0;
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] == arr[lo] && arr[mid] == arr[hi])
                return getMinIndex(arr, lo, hi);
            if (arr[mid] <= arr[hi])
                hi = mid;
            else
                lo = mid + 1;
        }
        return arr[lo];
    }

    // case1: [1,1,3,1]
    // case2: [1,1,0,1]
    // case3: [1,1,1,1]
    // 可获得最小值, 不可获得最小值索引位置
    private int getMinIndex(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i ++) {
            if (arr[i] )
        }

    }*/
}
