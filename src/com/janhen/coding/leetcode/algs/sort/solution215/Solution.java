package com.janhen.coding.leetcode.algs.sort.solution215;

class Solution {
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // time: O(n), space: O(1)
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        int lo = 0, hi = N - 1;
        k = N - k;            // ==>   kthLowest
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j == k)
                return nums[k];
            else if (j < k)
                lo = j + 1;
            else
                hi = j - 1;
        }
        return nums[k];
    }

    public int partition(int[] nums, int lo, int hi) {
        // select one pivot to part
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            // find first not meet the condition
            while (nums[++i] < pivot) if (i == hi) break;
            while (nums[--j] > pivot) if (j == lo) break;
            // handle index edge
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        // put pivot to appropriate position
        swap(nums, j, lo);
        return j;
    }
}
