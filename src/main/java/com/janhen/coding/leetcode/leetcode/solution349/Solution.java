package main.java.janhen.leetcode.leetcode.solution349;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
// easy

import java.util.*;

public class Solution {

    // sort + double index
    // time : O(nlogn), space : O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new TreeSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i ++;
                j ++;
            }
            else if (nums1[i] < nums2[j]) {
                i ++;
            }
            else
                j ++;
        }

        int[] res = new int[set.size()];
        int index = 0;
        for (Integer val : set)
            res[index] = val;

        return res;
    }
}

//        Iterator<Integer> it = set.iterator();
//        for (int i = 0; i < set.size(); i++)
//            res[i] = it.next();

