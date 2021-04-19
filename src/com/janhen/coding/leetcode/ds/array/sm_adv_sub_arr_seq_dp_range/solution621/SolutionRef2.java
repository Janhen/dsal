package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution621;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
 */
class SolutionRef2 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
