package main.java.janhen.leetcode.search.solution350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2_my {

    // 7 ms, faster than 27.02% 
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums1)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {                // ∃,remove or --
            if (freqs.containsKey(num)) {
                res.add(num);
                freqs.put(num, freqs.get(num) - 1);
                if (freqs.get(num) == 0)
                    freqs.remove(num);   // this element not have in all
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
