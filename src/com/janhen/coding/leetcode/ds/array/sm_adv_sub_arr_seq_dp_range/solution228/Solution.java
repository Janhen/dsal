package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        // Maintain boundary
        int begin = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Check continuous
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                res.add(geneRange(begin, end));          // need to collect result
                // Reset boundary continue to find other segment
                begin = nums[i];
                end = nums[i];
            }
        }
        res.add(geneRange(begin, end));
        return res;
    }

    private String geneRange(int begin, int end) {
        if (begin == end) {
            return "" + begin;
        }
        return begin + "->" + end;
    }
}
