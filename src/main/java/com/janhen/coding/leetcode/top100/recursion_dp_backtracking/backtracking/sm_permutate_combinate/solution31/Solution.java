package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        for (int i = N-1; i >=1; i --) {
            if (nums[i-1] < nums[i]) {  //
                int minGreaterIndex = findMinGreater(nums, i, N-1, nums[i-1]);
                swap(nums, minGreaterIndex, i -1);
                Arrays.sort(nums, i, N);
                return;
            }
        }
        reverse(nums);
    }

    private void reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j)
            swap(a,  i ++, j --);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // [R] → [L]：  ↑  在递减数组中寻找大于某个给定值的最小
    private int findMinGreater(int[] nums, int lo, int hi, int key) {
        for (int i = hi; i >= lo; i --)
            if (nums[i] > key)
                return i;
        return -1;
    }
}