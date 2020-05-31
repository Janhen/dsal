package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        findPermutations(nums, 0, visited, new ArrayList<>(), permutations);
        return permutations;
    }

    private void findPermutations(int[] nums, int curIndex, boolean[] visited, List<Integer> curPermutation, List<List<Integer>> permutations) {
        if (curIndex == nums.length) {
            permutations.add(new ArrayList<>(curPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (visited[i])
                continue;
            // skip duplication 下一个重复值只有在前一个重复值被使用的情况下才可以使用
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            curPermutation.add(nums[i]);
            visited[i] = true;

            findPermutations(nums, curIndex + 1, visited, curPermutation, permutations);

            curPermutation.remove(curPermutation.size() - 1);
            visited[i] = false;
        }
    }
}
