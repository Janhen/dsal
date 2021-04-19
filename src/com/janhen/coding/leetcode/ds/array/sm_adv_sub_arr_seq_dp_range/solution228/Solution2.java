package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution228;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> summaryRanges(int[] nums) {
        int begin = 0;
        int end = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // find max can meet the conditions
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                end++;
                // iterate increase
                i++;
            }

            // collect result
            if (begin == end) {
                list.add(String.valueOf(nums[begin]));
            } else {
                list.add(nums[begin] + "->" + nums[end]);
            }

            // reset for continue to find
            end++;
            begin = end;
        }
        return list;

    }
}