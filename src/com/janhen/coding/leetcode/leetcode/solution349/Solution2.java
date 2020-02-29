package com.janhen.leetcode.leetcode.solution349;

import java.util.*;

public class Solution2 {

    // 利用 set 自动去重性质
    // time : O(n), space:O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        // aux structures to Eliminate unnecessary results
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int num : nums1)
            set.add(num);

        for (int num : nums2)
            if (set.contains(num))
                resSet.add(num);

        int[] res = new int[resSet.size()];
        int i = 0;
        for (int val : resSet)
            res[i ++] = val;
        return res;
    }
}

