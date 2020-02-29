package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)  {
            return res;
        }
        int begin = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                res.add(geneRange(nums, begin, end));          // need to collect result
                begin = nums[i];
                end = nums[i];
            }
        }
        res.add(geneRange(nums, begin, end));     // need to handle tail
        return res;
    }

    // can handle
    private String geneRange(int[] nums, int begin, int end) {
        if (begin == end) {
            return "" + begin;
        }
        return begin + "->" + end;
    }
}
