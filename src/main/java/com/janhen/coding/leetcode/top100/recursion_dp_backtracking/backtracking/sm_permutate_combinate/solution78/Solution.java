package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        backtracking(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));          // every temporary result also can as subset
        for (int i = start; i < nums.length; i ++) {
            subset.add(nums[i]);
            backtracking(nums, i + 1, subset, res);    // i+1, not can use one element many time
            subset.remove(subset.size() - 1);
        }
    }
}