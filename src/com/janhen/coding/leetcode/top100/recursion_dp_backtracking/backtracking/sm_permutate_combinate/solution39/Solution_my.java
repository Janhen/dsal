package com.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_my {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationSum(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void findCombinationSum(int[] candidates, int target, int start, List<Integer> curCombination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(curCombination));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {    // cur can select [start] ~ [N-1]
            if (candidates[i] > target ) continue;     // use for punning
            curCombination.add(candidates[i]);    // collection current selected result
            findCombinationSum(candidates, target - candidates[i], i, curCombination, combinations);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
