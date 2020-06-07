package com.janhen.coding.leetcode.backtracking.subset.solution90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int sz = 0; sz <= nums.length; sz ++) {
            backtracking(nums, 0, sz, list, visited, res);
        }
        return res;
    }

    private void backtracking(int[] nums, int start, int size, List<Integer> list, boolean[] visited, List<List<Integer>> res) {
        if (size == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i ++) {
            if (i > start && nums[i] == nums[i-1] && !visited[i-1])
                continue;                                   // no need to handle visited[i]
            list.add(nums[i]);
            visited[i] = true;

            backtracking(nums, i + 1, size, list, visited, res);

            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
