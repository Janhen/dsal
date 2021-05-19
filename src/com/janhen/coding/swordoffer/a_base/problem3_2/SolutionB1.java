package com.janhen.coding.swordoffer.a_base.problem3_2;

public class SolutionB1 {

    // 辅助空间实现
    // time: O(N), space: O(N)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // mock map: value -> exist
        boolean[] occur = new boolean[n];
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (occur[val]) {
                return val;
            }
            occur[val] = true;
        }
        return -1;
    }
}
