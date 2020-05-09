package com.janhen.coding.leetcode.recursionANDbacktracking.solution77;

import java.util.ArrayList;
import java.util.List;
class Solution {
    /* 相当于从排序的无重复元素的数组中选择k个元素 */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n)
            return res;
        backtracking(n, k, 1, new ArrayList<>(), res);
        return res;

    }

    // C (n, k) 当前已经找到存储在 list 中，需要从  start 开始搜索新的元素
    // list.size() 控制终止条件
    private void backtracking(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i ++) {
            list.add(i);
            backtracking(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}