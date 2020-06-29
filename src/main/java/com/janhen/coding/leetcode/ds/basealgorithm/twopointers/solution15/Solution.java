package com.janhen.coding.leetcode.ds.basealgorithm.twopointers.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 控制结果中可含有重复元素, 整体结果在结果集中唯一
 * 多结果收集时, 命中之后 pointer 调整
 * [-2,0,0,2,2]
 * [-1,0,1,2,-1,-4]           [[-1,-1,2],[-1,0,1]]
 */
class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length < 3)
      return res;
    // 1. sort
    Arrays.sort(nums);
    // 2. iterate
    for (int i = 0; i < nums.length - 2; i++) {
      // 3.1 find to skip duplication
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));
          // 3.2 find to skip duplication
          while (l < r && nums[l] == nums[l + 1]) l++;
          while (l < r && nums[r] == nums[r - 1]) r--;
          l++;             // l,r to first not duplication
          r--;
        } else if (sum > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
    return res;
  }
}