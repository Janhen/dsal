package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution128;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        // copy and duplicate removal
        Set<Integer> set = IntStream.of(nums).boxed().collect(toSet());

        for (int n : nums) {
            int cnt = 1;
            int num = n;
            // not sorted
            while (set.contains(++ num)) {          // delete from left to rigth
                cnt ++;
                set.remove(num);
            }
            num = n;
            while (set.contains(-- num)) {          // delete from right to left
                cnt ++;
                set.remove(num);
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
