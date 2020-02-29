package com.janhen.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution347;

import java.util.*;

public class SolutionPQ {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1,o2) -> !o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getValue(), o2.getValue()) : Integer.compare(o1.getKey(), o2.getKey()));
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            pq.offer(entry);
            if (pq.size() == k + 1)
                pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(pq.poll().getKey());
        return res;
    }
}
