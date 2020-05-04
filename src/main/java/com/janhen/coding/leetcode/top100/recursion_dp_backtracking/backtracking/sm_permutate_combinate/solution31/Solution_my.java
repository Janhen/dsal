package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution31;

import java.util.Arrays;

public class Solution_my {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        for (int i = N-1; i >=1; i --) {
            if (nums[i-1] < nums[i]) {  // head → tail    need replace [i-1] position value
                int minGreaterIndex = minGreaterIndex(nums, i, N - 1, nums[i - 1]);
                swap(nums, i - 1, minGreaterIndex);
                Arrays.sort(nums, i, N);
                return;
            }
        }
        reverse(nums);
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j)
            swap(nums, i ++, j --);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int minGreaterIndex(int[] nums, int lo, int hi, int key) {
        for (int i = hi; i >= lo; i --) {     // use [lo, hi] ↓ property
            if (nums[i] > key) {
                return i;
            }
        }
        return -1;
    }
}
