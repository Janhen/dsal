package com.janhen.coding.leetcode.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution215;

class Solution2 {

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
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++ i] < pivot) if (i == hi) break;          // find first not meet the condition
            while (nums[-- j] > pivot) if (j == lo) break;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, j, lo);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
