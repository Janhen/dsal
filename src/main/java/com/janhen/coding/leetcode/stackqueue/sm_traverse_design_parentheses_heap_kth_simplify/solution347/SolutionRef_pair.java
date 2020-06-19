package com.janhen.coding.leetcode.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution347;

import javafx.util.Pair;

import java.util.*;

// 84 ms, faster than 3.97%
public class SolutionRef_pair {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((h1, h2) -> {
            return h1.getValue() - h2.getValue();
        });
        for (Integer key : map.keySet()) {
            Pair<Integer, Integer> h = new Pair<>(key, map.get(key));
            heap.offer(h);
            if (heap.size() == k + 1)
                heap.poll();
        }
        while (!heap.isEmpty()) {
            res.add(heap.poll().getKey());
        }
        return res;
    }
}
