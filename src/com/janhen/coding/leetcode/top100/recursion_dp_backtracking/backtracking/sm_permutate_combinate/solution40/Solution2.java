package com.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution40;

// 40. Combination Sum II
//https://leetcode.com/problems/combination-sum-ii/

/*

Medium

677

37

Favorite

Share
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may 【only be used once】 in the combination.

Note:

All numbers (including target) will be 【positive】 integers.
The solution62 set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution62 set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution62 set is:
[
  [1,2,2],
  [5]
]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    /* 结果中个数不确定 */
    //  9 ms, faster than 90.84%
    //26 MB, less than 56.28%
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] <= target) {          /* 剪枝优化 */
                list.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i + 1, list);      /* 组合的总体个数不确定, 从其中选择一个元素放入, 之后向下寻找;  每次都为下一个元素 */
                list.remove(list.size() - 1);
            }
        }
    }
}