package com.janhen.coding.leetcode.ds.hashtable.solution349;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 {
    // 利用 set 自动去重性质
    // time : O(n), space:O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        // aux structure to Eliminate unnecessary results
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(set::contains).distinct().toArray();
    }
}
