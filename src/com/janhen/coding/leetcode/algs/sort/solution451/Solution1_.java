package com.janhen.coding.leetcode.algs.sort.solution451;

import java.util.Collections;
import java.util.stream.Collectors;

class Solution1_ {
    public String frequencySort(String s) {
        return s.chars().mapToObj(a -> (char) a)
          .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum)) // get freqs
          .entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue())  // sort by freq
          .map(a -> String.join("", Collections.nCopies(a.getValue(), String.valueOf(a.getKey())))) // map by freq
          // and key
          .collect(Collectors.joining()); // join to return
    }
}