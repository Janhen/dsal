package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution744;

class Solution {
  // ceil
  public char nextGreatestLetter(char[] letters, char target) {
    int lo = 0, hi = letters.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (letters[mid] > target) {                // greater than
        if (mid == 0 || letters[mid - 1] <= target)     // previous not greater than
          return letters[mid];
        else
          hi = mid - 1;
      } else
        lo = mid + 1;
    }
    return letters[0];
  }
}