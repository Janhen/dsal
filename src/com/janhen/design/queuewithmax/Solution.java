package com.janhen.design.queuewithmax;

import java.util.Arrays;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    MaxQueue maxQueue = new MaxQueue();
    int index = 0;
    for (int i = 0; i < nums.length; i ++) {
      maxQueue.offer(nums[i]);
      if (i >= k - 1) {
        res[index ++] = maxQueue.max();
        maxQueue.poll();
      }
    }
    return res;
  }
//  public static void main(String[] args) {
//    int[] nums = {1,3,-1,-3,5,3,6,7};
//    int k = 3;
//    int[] ints = new Solution().maxSlidingWindow(nums, k);
//    System.out.println(Arrays.toString(ints));
//  }
}