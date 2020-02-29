package com.janhen.leetcode.array.sm_binary_search.solution81;

import java.util.Arrays;

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int firstIndex = getFirstIndex(nums);
        if (nums[nums.length-1] >= target) {
            int index = Arrays.binarySearch(nums, firstIndex, nums.length, target);
            return index >= 0;
        } else {
            int index = Arrays.binarySearch(nums, 0, firstIndex, target);
            return index >= 0;
        }
    }

    private int getFirstIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == nums[lo] && nums[mid] == nums[hi])
                return getMinIndex(nums, lo, hi);
            if (nums[mid] <= nums[hi])
                hi = mid;   // [mid] in sub2, first int left half, first can be [mid]
            else
                lo = mid + 1;
        }
        return lo;
    }

    // case1: [1,1,3,1]
    // case2: [1,1,0,1]
    // case3: [1,1,1,1]
    // NOTE: not find first element, is find first element index
    private int getMinIndex(int[] nums, int lo, int hi) {
        for (int i = lo + 1; i < hi; i ++) {
            if (nums[i] == nums[lo])
                continue;
            else if (nums[i] < nums[lo]) {    // nums[lo] as excepted
                return i;
            } else if (nums[i] > nums[lo]) {
                for (int j = i + 1; j <= hi; j ++)    // find first equal [lo]
                    if (nums[j] == nums[lo])
                        return j;
            }
        }
        return lo;
    }
}