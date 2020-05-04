package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.sm_permutate_combinate.solution78;

import java.util.ArrayList;
import java.util.List;

public class Solution_my {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        for (int sz = 0; sz <= nums.length; sz ++) {
            findSubsetsInSize(nums, sz, 0, subset, subsets);
        }
        return subsets;
    }

    private void findSubsetsInSize(int[] nums, int k, int start, List<Integer> subset, List<List<Integer>> subsets) {
        if (k == 0) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        for (int i = start; i < nums.length; i ++) {
            subset.add(nums[i]);
            findSubsetsInSize(nums, k - 1, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
