package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution216;


import java.util.ArrayList;
import java.util.List;

class Solution2 {
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        backtracking(1, k, n, new ArrayList<>());
        return res;
    }

    private void backtracking(int start, int k, int n, List<Integer> list) {
        if (list.size() > k) return;
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtracking(i + 1, k, n - i, list);    // start is i+1, not start
            list.remove(list.size() - 1);
        }
    }
}