package com.janhen.coding.swordoffer.a_base.problem3_2;

public class SolutionB1 {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] occur = new boolean[n];
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (occur[v]) {
                return v;
            }
            occur[v] = true;
        }
        return -1;
    }
}
