package com.janhen.coding.leetcode.backtracking.combinate.solution40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_my {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        Arrays.sort(candidates);
        findCombinationSum(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void findCombinationSum(int[] candidates, int target, int start, List<Integer> curCombination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(curCombination));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) continue;
            curCombination.add(candidates[i]);
            findCombinationSum(candidates, target - candidates[i], i + 1, curCombination, combinations);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
