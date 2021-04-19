package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution34;

class Solution {

    // first occur index to reduce last search range
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums, 0, nums.length - 1, target);
        if (first < 0)
            return new int[]{-1, -1};

        // reduce search range
        int last = binarySearchLast(nums, first, nums.length - 1, target);
        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // first index in duplication array that equal specify the number
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1])
                    return mid;
                else
                    hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1])
                    return mid;
                else
                    lo = mid + 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}