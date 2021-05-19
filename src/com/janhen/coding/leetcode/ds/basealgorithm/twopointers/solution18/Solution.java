package com.janhen.coding.leetcode.ds.basealgorithm.twopointers.solution18;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //  38 ms, faster than 74.57%
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])      // prevent duplication
                continue;
            for (int j = i + 1; j < N - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])   // prevent duplication
                    continue;
                int p = j + 1, q = N - 1;
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum > target)
                        q--;
                    else if (sum < target)
                        p++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        while (p < q && nums[p] == nums[p + 1]) p++;    // skip duplication
                        while (p < q && nums[q] == nums[q - 1]) q--;
                        p++;
                        q--;
                    }
                }
            }
        }
        return res;
    }
}