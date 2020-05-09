package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution209;

// time : O(n^2)
// space : O(1)
class SolutionBF {

    public int minSubArrayLen(int s, int[] nums) {
        if (s < 0 || nums == null)
            throw new IllegalArgumentException();
        if (nums.length == 0)
            return 0;

        int N = nums.length;
        int res = Integer.MAX_VALUE;

        int[] sums = new int[N + 1];
        for (int i = 1; i <= N; i ++)
            sums[i] = sums[i - 1] + nums[i - 1];

        int cur = 0;
        for (int l = 0; l < N; l ++) {
            for (int r = l; r < N; r ++) {
                cur = sums[r + 1] - sums[l];         // sum(l,r)
                if (cur >= s) res = Math.min(res, r - l + 1);
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
