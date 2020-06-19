package com.janhen.coding.leetcode.search.backtracking.subset.solution78;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // subset elements count can 0 ~ all element count
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int sz = 0; sz <= nums.length; sz ++)    // fixed element count to combine
             backtracking(nums, 0, sz, list, res);
        return res;
    }

    public void backtracking(int[] nums, int start, int size, List<Integer> list, List<List<Integer>> res) {
        // sz to control result count
        if (size == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i ++) {
            list.add(nums[i]);
            backtracking(nums, i + 1, size, list, res);
            list.remove(list.size() - 1);
        }
    }
}
