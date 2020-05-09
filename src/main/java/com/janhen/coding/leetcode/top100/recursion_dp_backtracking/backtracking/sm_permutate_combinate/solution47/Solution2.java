package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 修改了原始数组
 *
 * 用递归实现。每个位置的数字都能和它后面的所有数字交换的，一共有n!种。
 *
 * 如果交换中两个数的中间有一个数和后面的交换数相同（说明前面的循环中已经生成过此种排列），则停止生成此种排列。
 *
 * 非 lamdba 2 ms, faster than 100.00%
 *
 * 39 ms
 *
 * 对于 2,1,1,3
 * [[1,1,2,3],[1,1,3,2],[1,2,1,3],[1,2,3,1],[1,3,2,1],[1,3,1,2],
 * [2,1,1,3],[2,1,3,1],[2,3,1,1],
 * [3,1,2,1],[3,1,1,2],[3,2,1,1]]
 */
class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);             
        backtracking(nums, 0, res);
        return res;
    }

    private void backtracking(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!canSwap(nums, start, i))
                continue;
            swap(nums, i, start);
            backtracking(nums, start + 1, res);
            swap(nums, i, start);
        }
    }

    // 判断是否需要 swap(start, end), [end] 在 [start,end) 中已经存在了, 代表之前已经计算过了, 此时剪枝
    private boolean canSwap(int[] nums, int start, int end) {
        for (int i = start; i < end; i ++)
            if (nums[i] == nums[end])
                return false;
        return true;
    }

    private void swap(int[] c, int i, int j) {
        if (i != j) {
            int t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
    }
}