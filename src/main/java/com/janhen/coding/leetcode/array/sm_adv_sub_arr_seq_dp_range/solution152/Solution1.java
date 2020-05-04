package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution152;

// sub recursiont_dp: 以[i]为结束的子数组
// 负数相乘的两种极端情况  ⇒ max, min record to find
// 需要保存之前的最小和最大情况，一次为依据来判断
class Solution1 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = res, curMin = res;
        for (int i = 1; i < nums.length; i ++) {
            int tmp = curMax;  // handle max override
            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));    // 子数组  ⇒ max{[i],max*[i]},  子序列  ⇒  max{max,max*[i]}
            curMin = Math.min(nums[i], Math.min(curMin * nums[i], tmp * nums[i]));
            res = Math.max(curMax, res);
        }
        return res;
    }
}