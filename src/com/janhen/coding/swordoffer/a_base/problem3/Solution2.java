package com.janhen.coding.swordoffer.a_base.problem3;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    // set 去重实现
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        Set<Integer> set = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            int val = nums[i];
            if (set.contains(val)) {
                duplication[0] = val;
                return true;
            }
            set.add(val);
        }
        return false;
    }
}