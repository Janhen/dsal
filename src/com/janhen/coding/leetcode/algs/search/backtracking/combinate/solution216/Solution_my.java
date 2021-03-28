package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution216;


import java.util.ArrayList;
import java.util.List;

class Solution_my {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(1, k, n, new ArrayList<>(), res);
    return res;
  }

  private void backtracking(int start, int k, int n, List<Integer> list, List<List<Integer>> res) {
    if (list.size() > k)
      return;
    if (list.size() == k && n == 0) {
      res.add(new ArrayList<>(list));
      return;
    }

    // element must ∈ [1,9]
    for (int i = start; i <= 9; i++) {
      list.add(i);
      backtracking(i + 1, k, n - i, list, res);    // start is i+1, not start
      list.remove(list.size() - 1);
    }
  }
}