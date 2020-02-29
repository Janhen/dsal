package com.janhen.leetcode.search.solution350;

//350. Intersection of Two Arrays II
//        https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// easy
// Hash Table, Two Pointers, Binary Search, Sort

/*
两个数组相同的数，可重复
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

import java.util.ArrayList;
import java.util.List;

public class Solution_my {
    // two list add + remove
    // 9 ms, faster than 17.56%
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> record = new ArrayList<>();    // every element record
        List<Integer> res = new ArrayList<>();
        for (int num : nums1)  // init record list
            record.add(num);

        for (int num : nums2) {             // ∃, remove
            if (record.contains(num)) {
                res.add(num);
                record.remove(Integer.valueOf(num));  // convert to value to remove
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
