package com.janhen.coding.swordoffer.a_base.problem3;

import java.util.BitSet;

public class Solution2_ {
    // biSet 去重实现
    // time： O(N)
    public boolean duplicate(int nums[], int length, int[] duplication) {
        BitSet set = new BitSet(length);
        for (int i = 0; i < length; i++) {
            int val = nums[i];
            if (set.get(val)) {
                duplication[0] = val;
                return true;
            }
            set.set(val);
        }
        return false;
    }
}