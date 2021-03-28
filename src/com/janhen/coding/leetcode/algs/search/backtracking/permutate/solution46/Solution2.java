package com.janhen.coding.leetcode.algs.search.backtracking.permutate.solution46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution2 {
  // char[] 交换方式收集排列
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0)
      return res;
    backTracking(nums, 0, res);
    return res;
  }

  // nums: all possible result and swap to backtracking
  // start: [start,N-1] possible result iterate
  // permutations: result collect
  private void backTracking(int[] nums, int start, List<List<Integer>> permutations) {
    if (start == nums.length) {
      List<Integer> permutation = Arrays.stream(nums).boxed().collect(Collectors.toList());
      permutations.add(permutation);
      return;
    }
    for (int i = start; i < nums.length; i++) {       // from [start] begin to select element
      swap(nums, start, i);
      backTracking(nums, start + 1, permutations);
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