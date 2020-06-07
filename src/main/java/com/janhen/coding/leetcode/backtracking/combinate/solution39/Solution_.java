package com.janhen.coding.leetcode.backtracking.combinate.solution39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_ {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {    // in this recursion is valid ANDfor controling
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;

            list.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
