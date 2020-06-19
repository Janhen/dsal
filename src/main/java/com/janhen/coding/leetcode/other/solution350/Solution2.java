package com.janhen.coding.leetcode.other.solution350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> freqs = new HashMap<>();
        // Word frequency statistics
        for (int num : nums1)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        // remove logic :
        //   - can reduce frequency
        //   - remove all element
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (freqs.containsKey(num)) {
                res.add(num);
                freqs.put(num, freqs.get(num) - 1);
                if (freqs.get(num) == 0)
                    freqs.remove(num);
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i ++)
            ret[i] = res.get(i);
        return ret;
    }
}
