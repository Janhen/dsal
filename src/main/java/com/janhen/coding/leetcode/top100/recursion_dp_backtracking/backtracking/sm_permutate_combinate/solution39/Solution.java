package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 排序避免重复
 * 回溯实现组合
 *
 * 未利用好有序向前可进行剪枝
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);                 // sort to prevent duplication
        backtracking(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            list.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], list, res);  // from i index, can use [i] many times
            list.remove(list.size() - 1);
        }
    }
}
