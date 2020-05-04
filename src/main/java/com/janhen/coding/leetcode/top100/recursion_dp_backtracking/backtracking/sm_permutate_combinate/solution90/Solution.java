package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // todo Q
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList(), res);
        return res;
    }

    private void backtracking(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i ++) {
            if (i > start && nums[i] == nums[i-1]) continue;           // skip duplication
            list.add(nums[i]);
            backtracking(nums, i + 1, list, res);          // like combination
            list.remove(list.size() - 1);
        }
    }
}
