package com.janhen.leetcode.leetcode.solution349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    // 利用动态删除 set 配合 list 进行去重 : max can save one time
    // time : O(n), space : O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        // type conversion
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++)
            res[i] = list.get(i);
        return res;
    }
}

