package com.janhen.coding.leetcode.algs.sort.solution347;

import javafx.util.Pair;

import java.util.*;

public class Solution$$ {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
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
