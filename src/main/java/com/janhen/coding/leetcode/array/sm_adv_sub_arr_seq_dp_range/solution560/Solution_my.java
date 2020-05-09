package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution560;

import java.util.HashMap;
import java.util.Map;

public class Solution_my {
    public int subarraySum(int[] nums, int k) {     //
        Map<Integer, Integer> curSumCntMap = new HashMap<>();
        curSumCntMap.put(0, 1);

        int curSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            curSum += nums[i];
            int key = curSum - k;
            if (curSumCntMap.containsKey(key)) {
                count += curSumCntMap.get(key);
            }
            curSumCntMap.put(curSum, curSumCntMap.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}
