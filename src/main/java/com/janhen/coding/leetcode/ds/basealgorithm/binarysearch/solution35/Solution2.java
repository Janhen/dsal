package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution35;

class Solution2 {
  public int searchInsert(int[] nums, int target) {
    int lo = 0, hi = nums.length;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (target > nums[mid])
        lo = mid + 1;
      else                    // target in left half section,   when key=[mid] ⇔ key is left half
        hi = mid;
    }
    return lo;
  }
}
