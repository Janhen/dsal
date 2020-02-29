package com.janhen.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution347;

import java.util.*;

// 68 ms, faster than 12.85%
public class SolutionRef_g {

    // lamdba + 匿名内部类作用域实现比较规则
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));   // only compare one attribute
        for (Integer key : map.keySet()) {
            pq.offer(key);
            if (pq.size() == k + 1)
                pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
}
