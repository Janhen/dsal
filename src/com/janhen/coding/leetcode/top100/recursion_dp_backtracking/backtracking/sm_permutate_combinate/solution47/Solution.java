package com.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 这个比一般的backtrack要难一点，有2个限制因素。
 *
 * 某个元素在某次递归中只能用一次。
 *
 * 重复。
 *
 * 主要就是这2个因素。
 *
 * 先SORT一下。
 *
 * 用visited[]记录哪个元素用过，用过直接跳过。
 *
 * 然后每个递归里，除了第一个元素之外，不许重复。
 *
 * if(i != 0 && nums[i] == nums[i-1] && visited[i-1]) continue;
 * 剩下的就是比较基础的backtrack了，记得每次要把visited恢复。
 *
 *
 *
 *
 * 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个。

在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素。

 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void backtracking(int[] nums, int start, List<Integer> list, boolean[] visited, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && !visited[i-1] && nums[i] == nums[i-1]) continue;             // 下一个重复值只有在前一个重复值被使用的情况下才可以使用
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backtracking(nums, start + 1, list, visited, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}