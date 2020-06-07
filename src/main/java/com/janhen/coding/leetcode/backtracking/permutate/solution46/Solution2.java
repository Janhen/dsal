package com.janhen.coding.leetcode.backtracking.permutate.solution46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        backTracking(nums, 0, res);
        return res;
    }
 
    private void backTracking(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i ++) {       // from [start] begin to select element
            swap(nums, start, i);
            backTracking(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j)
            return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}