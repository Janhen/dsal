package com.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution216;

import java.util.ArrayList;
import java.util.List;

class SolutionB {
    private List<List<Integer>> res = new ArrayList<>();

    // 保持原始传递值进行递归
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        backtracking(1, k, n, new ArrayList<>());
        return res;
    }

    private void backtracking(int start, int k, int n, List<Integer> list) {
        if (list.size() > k) return;
        if (list.size() == k && sum(list) == n) {
            res.add(new ArrayList<>(list));
            return;  // note: return
        }
        for (int i = start; i <= 9; i ++) {                /* 固定数量的选择 */
            list.add(i);
            backtracking(i + 1, k, n, list);
            list.remove(list.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int val: list)
            sum += val;
        return sum;
    }

}