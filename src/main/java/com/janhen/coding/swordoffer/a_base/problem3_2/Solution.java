package main.java.janhen.swordoffer.a_base.problem3_2;

import java.util.stream.IntStream;

public class Solution {
    public int getDulplication(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int count = countOfRange(nums, lo, mid);
            if (lo == hi) {
                if (count > 1) return lo;
                else break;
            }
            if (count > (mid - lo + 1))
                hi = mid;
            else
                lo = mid + 1;
        }
        return -1;
    }

    private int countOfRange(int[] nums, int from, int to) {
        return (int) IntStream.of(nums).filter(val -> val >= from && val <= to).count();
    }
}
