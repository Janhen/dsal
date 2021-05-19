package com.janhen.coding.leetcode.algs.sort.solution451;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution1 {
    public String frequencySort(String s) {
        // 1. frequency statistics
        Map<Character, Integer> freqs =
          s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(Function.identity(), val -> 1, Integer::sum));

        return freqs.keySet().stream()
          .sorted(Comparator.comparingInt(freqs::get).reversed()) // 2. heap to sort by frequency
          .map(o -> String.join("", Collections.nCopies(freqs.get(o), String.valueOf(o))))  // 3. build duplicate string
          .collect(Collectors.joining());
    }
}
