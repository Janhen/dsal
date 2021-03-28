package com.janhen.coding.swordoffer.a_good.problem45;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 指定特殊的比较方法，借助贪心思想进行处理
 */
public class Solution {
    public String PrintMinNumber(int [] nums) {
        String[] arr = (String[]) IntStream.of(nums).mapToObj(String::valueOf).collect(Collectors.toList()).toArray();
        Arrays.sort(arr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        return Arrays.stream(arr).collect(Collectors.joining(""));
    }
}
