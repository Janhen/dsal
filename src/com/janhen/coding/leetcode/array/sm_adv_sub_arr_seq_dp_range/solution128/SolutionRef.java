package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * _ _ _ _      _ _ _ _       _ _ _   _     _ _ _     _ _       _
 * 42 ms, faster than 10.78%
 */
class SolutionRef {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int n : nums) {
            int cnt = 1;
            int num = n;
            while (set.contains(++ num)) {
                cnt ++;
                set.remove(num);
            }
            num = n;
            while (set.contains(-- num)) {
                cnt ++;
                set.remove(num);
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
