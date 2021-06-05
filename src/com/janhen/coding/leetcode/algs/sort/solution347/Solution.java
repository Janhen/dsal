package com.janhen.coding.leetcode.algs.sort.solution347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. frequency statistics
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        // 2. map to sort nums freq by storage additional attribute
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freqs::get));
        // 3. fixed size pq to find kth frequency number
        for (Integer key : freqs.keySet()) {
            pq.offer(key);
            if (pq.size() == k + 1)
                pq.poll();
        }
        // 4. return value by priority queue iterate
        return pq.stream().mapToInt(Integer::valueOf).toArray();
    }
}
