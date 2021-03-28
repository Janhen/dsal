package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
  /* 结果中个数不确定 */
  //26 MB, less than 56.28%
  private List<List<Integer>> res;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    res = new ArrayList<>();
    if (candidates == null || candidates.length == 0)
      return res;
    Arrays.sort(candidates);
    backtracking(candidates, target, 0, new ArrayList<>());
    return res;
  }

  private void backtracking(int[] candidates, int target, int start, List<Integer> list) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1]) continue;
      if (candidates[i] <= target) {          /* 剪枝优化 */
        list.add(candidates[i]);
        backtracking(candidates, target - candidates[i], i + 1, list);      /* 组合的总体个数不确定, 从其中选择一个元素放入, 之后向下寻找;  每次都为下一个元素 */
        list.remove(list.size() - 1);
      }
    }
  }
}