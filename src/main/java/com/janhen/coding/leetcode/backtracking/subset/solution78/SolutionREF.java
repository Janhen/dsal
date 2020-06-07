package com.janhen.coding.leetcode.backtracking.subset.solution78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionREF {
    // No messy indexing. Avoid the ConcurrentModificationException by using a temp list.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(num);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}