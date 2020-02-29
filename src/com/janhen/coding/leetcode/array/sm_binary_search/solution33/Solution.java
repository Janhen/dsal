package com.janhen.leetcode.array.sm_binary_search.solution33;

class Solution {
    // todo
    public int search(int[] nums, int target) {
        int smallestIndex = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi])     // [mid] in R half,  smallest in R half
                hi = mid;
            else         // [mid] in L half, smallest in R half
                lo = mid + 1;
        }
        smallestIndex = lo;

        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {         // binary search with offset
            int mid = lo + (hi - lo) / 2;
            int realMid = (mid + smallestIndex) % nums.length;   // add offset
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