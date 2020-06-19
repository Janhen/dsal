package com.janhen.coding.leetcode.search.backtracking.subset.solution78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class SolutionRef2 {
    List<List<Integer>> res = new ArrayList<>();

    // 排序并在回溯中判断
    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        Arrays.sort(nums);

        backtracking(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtracking(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;  // prevent duplicate element
            list.add(nums[start]);
            backtracking(nums, start + 1, list);
            list.remove(list.size() - 1);
        }
    }
}