package com.janhen.coding.leetcode.hashtable.practice.solution451;

import java.util.*;
import java.util.stream.Collectors;

// 19 ms, faster than 85.88%
class Solution2 {

    public String frequencySort(String s) {
        return s.chars().mapToObj(a->(char)a)
          .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum))
          .entrySet().stream().sorted((a, b)->b.getValue()-a.getValue())
          .map(a->String.join("", Collections.nCopies(a.getValue(),String.valueOf(a.getKey())))).collect(Collectors.joining());
    }
}