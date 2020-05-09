package com.janhen.coding.leetcode.search.solution349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution3_my {

    // set + list + dynamic property
    // 利用动态删除 set 配合 list 进行去重 : max can save one time
    // time : O(n), space : O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums1)      // init map set
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {   // ∃, remove
                list.add(num);
                set.remove(num);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

