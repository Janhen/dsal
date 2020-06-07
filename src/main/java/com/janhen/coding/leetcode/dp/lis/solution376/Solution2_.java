package com.janhen.coding.leetcode.dp.lis.solution376;

class Solution2_ {

    public int wiggleMaxLength(int[] nums) {

        if(nums == null || nums.length <= 1) return nums.length;

        int upMax = 0, downMax = 0;   // 以 up 为结尾的最大长度; 以 down 为结尾的最大长度

        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i-1]) {
                upMax = downMax + 1;
            } else if (nums[i] < nums[i-1]) {
                downMax = upMax + 1;
            }
        }
        return Math.max(upMax, downMax);
    }
}