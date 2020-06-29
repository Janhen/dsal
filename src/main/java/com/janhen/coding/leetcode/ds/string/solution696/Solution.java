package com.janhen.coding.leetcode.ds.string.solution696;

// 696. Count Binary Substrings
//https://leetcode.com/problems/count-binary-substrings/description/

/*
统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
0 和1 连续, 总个数相同
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.*/

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