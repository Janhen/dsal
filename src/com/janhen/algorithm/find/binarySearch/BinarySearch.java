package com.janhen.algorithm.find.binarySearch;

/**
 * 基本的二分查找
 *
 * @author Janhen
 */
public class BinarySearch {
    /**
     * [a, b] 闭区间方式
     *
     * @param arr  待查找数组
     * @param target  查找的元素
     * @return  数组中的位置
     */
    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    /**
     * [a, b) 开区间方式
     *
     * @param arr  待查找数组
     * @param target  查找的元素
     * @return  数组中的位置
     */
    public static int binarySearch2(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target < arr[m]) {
                r = m;
            } else if (target > arr[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
