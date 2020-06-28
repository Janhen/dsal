package com.janhen.coding.leetcode.ds.array.binarysearch.solution33;

class SolutionNR {
  public int search(int[] nums, int aim) {
    int L = 0, R = nums.length - 1;
    while (L <= R) {
      int mid = L + (R - L) / 2;
      if (nums[mid] == aim)    // no duplication
        return mid;

      // aim in [L, R]
      if (nums[L] < nums[mid]) {   // L half is sort
        if (aim < nums[mid] && aim >= nums[L])    // aim in L half  ⇒  [L, mid)
          R = mid - 1;
        else
          L = mid + 1;
      } else if (nums[mid] < nums[R]) {  // R half is sort
        if (aim <= nums[R] && aim > nums[mid])     // aim in R half ⇒ (mid, R]
          L = mid + 1;
        else
          R = mid - 1;
      } else if (nums[L] == nums[mid]) { // L half is all same or loops around(with R half all same)   [1,2,1,1,1]
        if (nums[mid] != nums[R]) {   // R half is not all same  ⇒  L half all same            [2,2,1,1], [3,3,1,2]
          L = mid + 1;
        } else {    // [1,1,0,1], [1,1,3,1], [1,1,1,1]
          // search in L half and R half
          R--;
        }
      }
    }
    return -1;
  }
}