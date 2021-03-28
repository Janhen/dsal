package com.janhen.coding.leetcode.ds.hashtable.solution350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//350. Intersection of Two Arrays II
//        https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// easy
// Hash Table, Two Pointers, Binary Search, Sort

/*
找出两个数组相同的数，可重复
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

/*
What if elements of nums2 are stored on disk, and the memory is
limited such that you cannot load all elements into the memory at
once?

If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

If both nums1 and nums2 are so huge that neither fit into the memory,
sort them individually (external sort),
then read 2 elements from each array at a time in memory, record intersections.
 */

public class Solution {

  // 7 ms, faster than 27.02%
  public int[] intersect(int[] nums1, int[] nums2) {
    // 1. frequency
    Map<Integer, Integer> freqs = new HashMap<>();
    for (int num : nums1)
      freqs.put(num, freqs.getOrDefault(num, 0) + 1);

    // 2. remove logic by frequency
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
    // 3. return result
    return res.stream().mapToInt(Integer::intValue).toArray();
  }
}
