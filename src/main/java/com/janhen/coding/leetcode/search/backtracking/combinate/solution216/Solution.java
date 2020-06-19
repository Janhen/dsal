package com.janhen.coding.leetcode.search.backtracking.combinate.solution216;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    // 通过值传递方式确定每次递归的参数, 避免每次取出list.size() 的调用开销
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        backtracking(k, n, 1, new ArrayList<>());
        return res;
    }

    private void backtracking(int k, int n, int start, List<Integer> list) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (k == 0 || n == 0)
            return;
        for (int i = start; i <= 9; i ++) {
            list.add(i);
            backtracking(k-1, n - i, i + 1, list);    // i +1 mean combination element only can use one time
            list.remove(list.size() - 1);
        }
    }
}