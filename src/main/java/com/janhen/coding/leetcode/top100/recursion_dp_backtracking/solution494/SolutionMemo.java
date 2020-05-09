package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution494;

import java.util.HashMap;
import java.util.Map;

class SolutionMemo {
    // []: index, map.key: S, map.val: possible sum count
    private Map<Integer, Integer>[] memo;
    public int findTargetSumWays(int[] nums, int S) {
        memo = new HashMap[nums.length + 1];
        for (int i = 0; i < memo.length; i ++)
            memo[i] = new HashMap<>();
        return findTargetSumWays(nums, S, 0);
    }

    private int findTargetSumWays(int[] nums, int S, int index) {
        if (memo[index].containsKey(S))
            return memo[index].get(S);
        if (index == nums.length) {
            memo[index].put(S, S == 0 ? 1 : 0);
            return S == 0 ? 1 : 0;
        }
        int res = 0;
        res += findTargetSumWays(nums, S - nums[index], index + 1);
        res += findTargetSumWays(nums, S + nums[index], index + 1);
        memo[index].put(S, res);
        return res;
    }
}