package main.java.janhen.leetcode.leetcode.solution350;

//350. Intersection of Two Arrays II
//        https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// easy

import java.util.ArrayList;

public class Solution {
    // two list add + remove
    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums1)
            list.add(num);

        for (int num : nums2) {
            if (list.contains(num)) {
                res.add(num);
                list.remove(Integer.valueOf(num));
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i ++)
            ret[i] = res.get(i);
        return ret;
    }
}
