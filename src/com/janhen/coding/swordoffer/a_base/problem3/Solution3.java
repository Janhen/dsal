package com.janhen.coding.swordoffer.a_base.problem3;

import java.util.Arrays;

public class Solution3 {
    // 排序实现
    public boolean duplicate(int nums[],int length,int [] duplication) {
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                duplication[0] = nums[i];
                return true;
            }
        }
        return false;
    }
}