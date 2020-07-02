package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  /* 结果中个数不确定 */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0)
      return res;
    Arrays.sort(candidates);
    findCombinationSum(candidates, target, 0, new ArrayList<>(), res);
    return res;
  }

  // backtracking to collect result
  private void findCombinationSum(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> combinations) {
    // can not find condition
    if (target < 0)
      return;
    // meet condition
    if (target == 0) {
      combinations.add(new ArrayList<>(combination));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      // in this cycle skip duplication
      if (i > start && candidates[i] == candidates[i - 1])
        continue;
      combination.add(candidates[i]);
      /* 组合的总体个数不确定, 从其中选择一个元素放入, 之后向下寻找;  每次都为下一个元素 */
      findCombinationSum(candidates, target - candidates[i], i + 1, combination, combinations);
      combination.remove(combination.size() - 1);
    }
  }
}