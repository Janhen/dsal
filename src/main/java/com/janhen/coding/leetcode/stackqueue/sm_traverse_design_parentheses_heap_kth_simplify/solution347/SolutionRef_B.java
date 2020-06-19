package com.janhen.coding.leetcode.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution347;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 68 ms, faster than 12.85%
public class SolutionRef_B {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        TreeMap<Integer, List<Integer>> buckets = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        for (Integer val : map.keySet()) {
            int freq = map.get(val);
            if (!buckets.containsKey(freq))
                buckets.put(freq, new ArrayList<>());
            buckets.get(freq).add(val);
        }

        List<Integer> res = new ArrayList<>();
        for (Integer freq : buckets.keySet()) {
            res.addAll(buckets.get(freq));
            if (res.size() >= k)
                break;
        }
        return res;
    }
}
