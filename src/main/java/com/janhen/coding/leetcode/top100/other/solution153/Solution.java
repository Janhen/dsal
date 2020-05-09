package com.janhen.coding.leetcode.top100.other.solution153;

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[hi])
                hi = mid;
            else
                lo = mid + 1;
        }
        return nums[lo];
    }
}