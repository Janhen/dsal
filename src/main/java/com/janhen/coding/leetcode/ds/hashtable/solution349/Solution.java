package com.janhen.coding.leetcode.ds.hashtable.solution349;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
// easy
// Hash Table, Two Pointers, Binary Search, Sort

/*
找出两个数组中重合的元素
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  // sort + double index
  // 3 ms, faster than 78.87%
  // time : O(nlogn), space : O(n)
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        set.add(nums1[i]); // handle duplicated element
        i++;
        j++;
      } else if (nums1[i] < nums2[j])
        i++;
      else
        j++;
    }

    int[] res = set.stream().mapToInt(Integer::intValue).toArray();
    return res;
  }
}
