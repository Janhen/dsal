package com.janhen.coding.swordoffer.a_base.problem3_2;

import java.util.stream.IntStream;

public class Solution {
    // 二分查找实现
    public int findDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int leftCount = countOfRange(nums, lo, mid);
            if (lo == hi) {
                if (leftCount > 1) {
                    return lo;
                } else {
                    break;
                }
            }
            // 左边范围的元素过多，在左边进行查找
            if (leftCount > (mid - lo + 1)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int countOfRange(int[] nums, int from, int to) {
        return (int) IntStream.of(nums).filter(val -> val >= from && val <= to).count();
    }
}
