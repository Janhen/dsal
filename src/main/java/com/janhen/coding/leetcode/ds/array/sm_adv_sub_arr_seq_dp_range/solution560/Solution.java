package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
    we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]

    1. Hashmap<sum[0,i - 1], frequency>
    2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
           k           sum      hashmap-key     -->  hashmap-key  =  sum - k
    3. now, we have k and sum.
          As long as we can find a sum[0, i - 1], we then get a valid subarray
         which is as long as we have the hashmap-key,  we then get a valid subarray
    4. Why don't map.put(sum[0, i - 1], 1) every time ?
          if all numbers are positive, this is fine
          if there exists negative number, there could be preSum frequency > 1

    Time complexity O(n), Space complexity O(n).
     */
    public int subarraySum(int[] nums, int k) {
        // sum[i] -> count, this frequency            map collect on iterative process
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        // TOWHY why need this
        preSumCnt.put(0, 1);

        int res = 0;
        // record cur iterated val summary
        int sum = 0;
        for (int num : nums) {
            sum += num;

            // need to find key
            int key = sum - k;

            if (preSumCnt.containsKey(key))
                res += preSumCnt.get(key);
            // maintain key's frequency
            preSumCnt.put(sum, preSumCnt.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
