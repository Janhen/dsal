package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution33;

class Solution {
    public int search(int[] nums, int target) {
        int smallestIndex = findMinInUniqueRotateArray(nums);
        return binarySearchWithOffset(nums, smallestIndex, target);
    }

    public int findMinInUniqueRotateArray(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) // [mid] in R half,  smallest in R half
                hi = mid;
            else                      // [mid] in L half, smallest in R half
                lo = mid + 1;
        }
        return lo;
    }

    private int binarySearchWithOffset(int[] nums, int offset, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // add offset
            int realMid = (mid + offset) % nums.length;
            if (nums[realMid] == target)
                return realMid;
            else if (nums[realMid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}