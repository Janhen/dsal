package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution560;

// time:O(n2), space:O(n)
public class SolutionBF {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // [i],[i+1]...[j]
                if (sum[j + 1] - sum[i] == k)
                    res += 1;
            }
        }
        return res;
    }
}
