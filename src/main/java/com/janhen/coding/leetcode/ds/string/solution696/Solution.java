package com.janhen.coding.leetcode.ds.string.solution696;

/*
 * 0001100
 *   01           preLen:3,curLen=1
 *  0011          preLen:3,curLen=2
 *     10         preLen:2,curLen=1
 *    1100        preLen:2,curLen=2
 */
class Solution {
  public int countBinarySubstrings(String s) {
    int preLen = 0, curLen = 1;             // record consecutive 0's OR 1's
    int res = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1))
        curLen++;
      else {
        preLen = curLen;
        curLen = 1;
      }
      if (preLen >= curLen)
        res++;
    }
    return res;
  }
}