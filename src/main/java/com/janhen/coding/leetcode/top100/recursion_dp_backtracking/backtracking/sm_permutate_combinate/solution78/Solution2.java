package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution78;

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
        if (size == list.size()) {                   // sz to control result count
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
