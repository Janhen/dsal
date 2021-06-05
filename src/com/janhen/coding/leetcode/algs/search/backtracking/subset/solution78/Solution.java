package com.janhen.coding.leetcode.algs.search.backtracking.subset.solution78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // convert subset problem to combination problem
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        // null set is one subset
        for (int sz = 0; sz <= nums.length; sz++) {
            findSubsetsInSize(nums, sz, 0, subset, subsets);
        }
        return subsets;
    }

    // fixed size subset
    // backtracking, combination
    private void findSubsetsInSize(int[] nums, int sz, int start, List<Integer> subset, List<List<Integer>> subsets) {
        if (sz == 0) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            // sz to sz -1 because start index to (start + 1)
            findSubsetsInSize(nums, sz - 1, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
