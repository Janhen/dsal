package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return permutations;

        boolean[] visited = new boolean[nums.length];
        findAllPermutations(nums, visited, new ArrayList<>(), permutations);
        return permutations;
    }

    // backtracking
    private void findAllPermutations(int[] nums, boolean[] visited, List<Integer> curPermutation, List<List<Integer>> permutations) {
        if (curPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(curPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (visited[i])
                continue;

            curPermutation.add(nums[i]);
            visited[i] = true;

            findAllPermutations(nums, visited, curPermutation, permutations);

            curPermutation.remove(curPermutation.size() - 1);
            visited[i] = false;
        }
    }
}
