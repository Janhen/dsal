package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution209;

class Solution1 {

    // window from [0,-1] begin can handle arr.length = 0 condition
    // time : O(n)
    // space : O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (s < 0 || nums == null)
            throw new IllegalArgumentException();
        if (nums.length == 0)
            return 0;

        int N = nums.length;
        int res = Integer.MAX_VALUE;

        int l = 0, r = -1;
        int sum = 0;
        while (r + 1 < N) {         // 窗口的右边界无法继续扩展了, 则循环继续; 基于 r 不断扩大实现
            while (r + 1 < N && sum < s)
                sum += nums[++ r];

            if (sum >= s)
                res = Math.min(res, r - l + 1);

            while (l < N && sum >= s) {
                sum -= nums[l ++];
                if (sum >= s)
                    res = Math.min(res, r - l + 1);
            }
        }

        return (res == Integer.MAX_VALUE) ? 0 : res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 1};
        int s = 7;
        System.out.println((new Solution1()).minSubArrayLen(s, nums));
    }
}
