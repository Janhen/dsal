package com.janhen.coding.leetcode.algs.sort.solution347;

import java.util.*;

public class SolutionLinkedHashMap {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        freqs = sortByValue(freqs);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            res.add(entry.getKey());
            if (res.size() == k)
                return res;
        }
        throw new IllegalArgumentException();
    }

    private Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> !o1.getValue().equals(o2.getValue()) ? Integer.compare(o2.getValue(), o1.getValue()) : Integer.compare(o1.getKey(), o2.getKey()));
        Map<Integer, Integer> newMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list)
            newMap.put(entry.getKey(), entry.getValue());
        return newMap;
    }
}
