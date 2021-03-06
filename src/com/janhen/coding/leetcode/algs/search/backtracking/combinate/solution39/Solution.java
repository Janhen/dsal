package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {

    /*
     排序避免重复
     回溯实现组合
     未利用好有序向前可进行剪枝
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // sort to prevent duplication
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    // start:          from [start, N-1) to find
    // curCombination: record combination
    // combinations:   record all meet condition combination result
    private void backtracking(int[] candidates, int start, int target, List<Integer> combination,
                              List<List<Integer>> combinations) {
        if (target < 0)
            return;
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            // from i index, can use [i] many times
            backtracking(candidates, i, target - candidates[i], combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}
