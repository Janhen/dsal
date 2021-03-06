package com.janhen.coding.leetcode.algs.search.backtracking.permutate.solution47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        // sort to skip duplication
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        findPermutations(nums, 0, visited, new ArrayList<>(), permutations);
        return permutations;
    }

    private void findPermutations(int[] nums, int curIndex, boolean[] visited, List<Integer> permutation,
                                  List<List<Integer>> permutations) {
        if (curIndex == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            // skip duplication 下一个重复值只有在前一个重复值被使用的情况下才可以使用
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            permutation.add(nums[i]);
            visited[i] = true;
            findPermutations(nums, curIndex + 1, visited, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
