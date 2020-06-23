package com.janhen.coding.leetcode.ds.stackqueue.monotonousstack.solution496;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
  // M = nums1.length
  // N = nums2.length
  // O(M + N)time O(N)space
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    LinkedList<Integer> stack = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      while (stack.size() > 0 && nums2[i] > stack.peek()) {
        map.put(stack.poll(), nums2[i]);
      }
      stack.push(nums2[i]) ;
    }
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = map.getOrDefault(nums1[i], -1);
    }
    return nums1;
  }
}
