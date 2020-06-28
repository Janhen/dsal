package com.janhen.coding.leetcode.ds.array.binarysearch.solution287;

// O(nlogn) O(1)
class Solution {
  // TODO
  public int findDuplicate(int[] nums) {
    int lo = 1, hi = nums.length - 1;                 // lo, hi mean value, then find count that in range in all array
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      // less equal
      int cnt = countOfLessEqual(nums, mid);

      if (cnt > mid)
        hi = mid - 1;   // duplication in left half
      else
        lo = mid + 1;   // cnt=mid, mean in [lo,mid] have no duplication, duplication(key) in right [mid+1,lo]
    }
    return lo;
  }

  private int countOfLessEqual(int[] nums, int key) {    // find in all array
    int cnt = 0;
    for (int num : nums)
      if (num <= key)
        cnt++;
    return cnt;
  }
}
