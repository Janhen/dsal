package com.janhen.leetcode.array.sm_binary_search.solution34;

class Solution_my {

    // first occur index to reduce last search range
    public int[] searchRange(int[] nums, int aim) {
        int first = binarySearchFirst(nums, 0, nums.length - 1, aim);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = binarySearchLast(nums, first, nums.length - 1, aim);   // reduce search range
        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int L, int R, int key) {
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == key) {
                if (mid == 0 || (mid > 0 && nums[mid-1] != nums[mid]))
                    return mid;
                else
                    R = mid - 1;
            } else if (nums[mid] < key)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int L, int R, int key) {
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == key) {
                if (mid == nums.length-1 || nums[mid] != nums[mid + 1])
                    return mid;
                else
                    L = mid + 1;
            } else if (nums[mid] < key)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return - 1;
    }
}