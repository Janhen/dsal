package com.janhen.swordoffer.a_base.problem21__;

public class Solution {

    public void reOrderArray(int[] nums) {
        if (nums == null || nums.length == 0)   return;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            while (nums[lo] %2 == 1 && lo < hi) lo++;
            while (nums[hi] %2 == 0 && lo < hi) hi--;

            if (hi - lo > 0) {
                int temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }
        }
    }
}
