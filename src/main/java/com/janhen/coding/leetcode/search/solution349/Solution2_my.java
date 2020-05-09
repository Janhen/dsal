package com.janhen.coding.leetcode.search.solution349;

import java.util.HashSet;
import java.util.Set;

public class Solution2_my {

    // double set
    // 利用 set 自动去重性质
    // time : O(n), space:O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        // aux structure to Eliminate unnecessary results
        Set<Integer> record = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int num : nums1)    // init map set
            record.add(num);

        for (int num : nums2)
            if (record.contains(num))
                resSet.add(num);
        return resSet.stream().mapToInt(Integer::valueOf).toArray();
    }
}

