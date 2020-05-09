package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution128;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    // todo Q
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums)
            countForNum.put(num, 1);          // collect unique
        for (int num : nums)
            forward(countForNum, num);
        return maxCount(countForNum);
    }

    private int forward(Map<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) return 0;
        int cnt = countForNum.get(num);
        if (cnt > 1) return cnt;                         // unsorted may calculate
        cnt = 1 + forward(countForNum, num + 1);
        countForNum.put(num, cnt);
        return cnt;
    }

    private int maxCount(Map<Integer, Integer> map) {
        int max = 0;
        for (Integer num : map.keySet())
            max = Math.max(max, map.get(num));
        return max;
    }
}
