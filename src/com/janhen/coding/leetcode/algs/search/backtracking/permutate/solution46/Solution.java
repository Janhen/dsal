package com.janhen.coding.leetcode.algs.search.backtracking.permutate.solution46;

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
  private void findAllPermutations(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> permutations) {
    if (permutation.size() == nums.length) {
      permutations.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i])
        continue;

      permutation.add(nums[i]);
      visited[i] = true;
      findAllPermutations(nums, visited, permutation, permutations);
      permutation.remove(permutation.size() - 1);
      visited[i] = false;
    }
  }
}
