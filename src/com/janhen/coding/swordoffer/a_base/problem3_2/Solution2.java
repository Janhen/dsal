package com.janhen.swordoffer.a_base.problem3_2;

import java.util.stream.IntStream;

public class Solution2 {
    public int getDulplication(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int count = countOfLessEqual(nums, mid);
            if (count > mid)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    private int countOfLessEqual(int[] nums, int key) {
        return (int) IntStream.of(nums).filter(val -> val <= key).count();
    }
}
