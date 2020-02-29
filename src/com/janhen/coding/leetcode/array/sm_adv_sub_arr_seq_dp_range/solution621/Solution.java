package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution621;

import java.util.*;

class Solution {
    // 获取最大频次以及为最大频次的元素个数
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (int i = 0; i < tasks.length; i++)
            freqs.put(tasks[i], freqs.getOrDefault(tasks[i], 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(((o1, o2) -> o1.getValue() != o2.getValue() ?
                Integer.compare(o2.getValue(), o1.getValue()) :
                Integer.compare(o1.getKey(), o2.getKey())));
        pq.addAll(freqs.entrySet());

        int count = 0;
        int maxFreq = pq.peek().getValue();
        while (!pq.isEmpty() && pq.peek().getValue() == maxFreq) {
            pq.poll();
            count ++;
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + count);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        (new Solution()).leastInterval(new char[]{'A','A','A','B','B','B'}, 2);
    }
}
