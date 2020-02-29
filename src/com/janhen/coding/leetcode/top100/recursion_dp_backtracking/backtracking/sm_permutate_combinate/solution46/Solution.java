package com.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, 0, new ArrayList<>(), res, visited);
        return res;
    }

    private void backtracking(int[] nums, int index, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) continue;

            list.add(nums[i]);
            visited[i] = true;
            backtracking(nums, index + 1, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}