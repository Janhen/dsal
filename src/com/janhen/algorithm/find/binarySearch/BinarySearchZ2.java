package com.janhen.algorithm.find.binarySearch;

/**
 * 带偏移的查找:
 * 可用于旋转数组的查找
 */
public class BinarySearchZ2 {

    private int binarySearchOffset(int[] nums, int key, int offset) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realMid = (mid + offset) % nums.length;
            if (nums[realMid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return -1;
    }
}
