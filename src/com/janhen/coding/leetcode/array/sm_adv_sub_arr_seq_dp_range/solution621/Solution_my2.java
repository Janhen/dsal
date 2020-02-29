package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution621;

import java.util.*;

public class Solution_my2 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            freqs.put(tasks[i], freqs.getOrDefault(tasks[i], 0) + 1);
        }

        freqs = sortByValue(freqs);
        int maxFreq = freqs.entrySet().iterator().next().getValue();
        int count = 0;
        for (Map.Entry<Character, Integer> entry : freqs.entrySet()) {
            if (entry.getValue() == maxFreq) {
                count ++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + count);
    }

    private Map<Character, Integer> sortByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        // reverse by frequency
        Collections.sort(list, (o1, o2) -> o1.getValue() != o2.getValue() ? Integer.compare(o2.getValue(), o1.getValue()) : Character.compare(o1.getKey(), o2.getKey()));
        Map<Character, Integer> newMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        return newMap;
    }
}
