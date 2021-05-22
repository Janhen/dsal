package com.janhen.coding.swordoffer.a_good.problem45;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_ {
    // 指定特殊的比较方法，借助贪心思想进行处理
    public String PrintMinNumber(int[] nums) {
        return IntStream.of(nums).mapToObj(String::valueOf)
          .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
          .collect(Collectors.joining());
    }
}
