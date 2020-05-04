package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_my {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            int curCount = 1;
            int curNum = num;
            while (set.contains(++ curNum)) {
                curCount ++;
                set.remove(curNum);
            }
            curNum = num;
            while (set.contains(-- curNum)) {
                curCount ++;
                set.remove(curNum);                         // remove to prevent duplication calculation
            }
            maxCount = Math.max(maxCount, curCount);
        }
        return maxCount;
    }
}
