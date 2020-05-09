package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2_ {
    /* 结果中个数不确定 */
    //  9 ms, faster than 90.84%
    //29.5 MB, less than 17.98%
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), new boolean[candidates.length]);
        return res;
    }

    // todo Q
    private void backtracking(int[] candidates, int target, int start, List<Integer> list, boolean[] visited) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (i > start && candidates[i] == candidates[i - 1] && !visited[i-1]) continue;
            if (candidates[i] <= target) {          /* 剪枝优化 */
                list.add(candidates[i]);
                visited[i] = true;
                backtracking(candidates, target - candidates[i], i + 1, list, visited);      /* 组合的总体个数不确定, 从其中选择一个元素放入, 之后向下寻找;  每次都为下一个元素 */
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}