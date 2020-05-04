package main.java.janhen.leetcode.search.solution350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {

    //  7 ms, faster than 27.02%
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> freqs = new HashMap<>();
        // Word frequency statistics
        for (int num : nums1)            // init freq record
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (freqs.containsKey(num) && freqs.get(num) > 0) {   // have this element
                res.add(num);
                freqs.put(num, freqs.get(num) - 1);                // no need judge and remove operation
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i ++)
            ret[i] = res.get(i);
        return ret;
    }
}
