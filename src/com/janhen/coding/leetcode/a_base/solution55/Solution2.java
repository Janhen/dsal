package com.janhen.leetcode.a_base.solution55;

/*
 * 限定数组值 >= 0, 若每个数组值 > 0 一定可达
 * 只有为0时需要判断
 */
class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        for (int i = 0; i < nums.length - 1; i ++) {    // [n-1] not need jump
            if (nums[i] == 0) {
                boolean possible = false;
                for (int j = 0; j < i; j ++) {
                    if (nums[j] + j > i) {   // must >, cur can not jump
                        possible = true;
                        break;
                    }
                }
                if (!possible) return false;
            }
        }
        return true;
    }
}