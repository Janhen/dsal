package com.janhen.coding.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionBucket {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int val : nums)
            freqs.put(val, freqs.getOrDefault(val, 0) + 1);

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(entry.getKey());
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i --) {
            if (buckets[i] == null) continue;
            if (topK.size() >= k) break;
            if (buckets[i].size() <= (k - topK.size()))
                topK.addAll(buckets[i]);
            else
                topK.addAll(buckets[i].subList(0, k - topK.size()));
        }
        return topK;
    }
}