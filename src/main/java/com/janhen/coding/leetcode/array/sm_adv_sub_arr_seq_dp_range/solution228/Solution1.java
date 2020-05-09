package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution228;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    // note: 尾处理, 单元素处理
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int begin = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i-1] + 1) {
                end = nums[i];
            } else {
                if (begin == end) res.add(begin+"");
                else res.add(begin + "->" + end);
                begin = end = nums[i];
            }
        }
        if (begin == end) res.add(begin+"");
        else res.add(begin + "->" + end);
        return res;
    }
}