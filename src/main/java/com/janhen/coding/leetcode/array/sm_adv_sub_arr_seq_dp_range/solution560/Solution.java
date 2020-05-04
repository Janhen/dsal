package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        preSumCnt.put(0, 1);             // why need this
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            int key = sum - k;
            if (preSumCnt.containsKey(key))
                res += preSumCnt.get(key);
            preSumCnt.put(sum, preSumCnt.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
