package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution152;

public class Solution_my {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int maxProduct = nums[0];
        int curMax = nums[0], curMin = nums[0];   // record product current iterator element max or min
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < 0) {
                int t = curMax;
                curMax = curMin;
                curMin = t;                      // max, min is determined by current element is or not negative
            }
            curMax = Math.max(curMax * nums[i], nums[i]);  // is or not continue
            curMin = Math.min(curMin * nums[i], nums[i]);
            maxProduct = Math.max(curMax, maxProduct);
        }
        return maxProduct;
    }
}
