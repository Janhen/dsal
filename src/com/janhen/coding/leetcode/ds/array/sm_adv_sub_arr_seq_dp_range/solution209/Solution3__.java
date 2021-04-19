package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution209;

class Solution3__ {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 1};
        int s = 7;
        System.out.println((new Solution3__()).minSubArrayLen(s, nums));
    }

    // time : O(n)
    // space : O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (s < 0 || nums == null)
            throw new IllegalArgumentException();
        if (nums.length == 0)
            return 0;

        int N = nums.length;
        int res = Integer.MAX_VALUE;

        int l = 0, r = 0;
        int cur = 0;
        while (r < N) {
            while (r < N && cur < s)
                cur += nums[r++];

            if (cur >= s)
                res = Math.min(res, r - l);

            while (l < N && cur >= s) {
                cur -= nums[l++];
                if (cur >= s)
                    res = Math.min(res, r - l);
            }
        }

        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
