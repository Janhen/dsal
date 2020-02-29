package com.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution46;

import java.util.ArrayList;
import java.util.List;

class SolutionCom {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        backTracking(nums, new ArrayList<>(), res);
        return res;
    }
 
    private void backTracking(int[] nums, ArrayList<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add((ArrayList<Integer>)list.clone());
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (list.contains(nums[i]))    // O(N)
                continue;
            list.add(nums[i]);
            backTracking(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}