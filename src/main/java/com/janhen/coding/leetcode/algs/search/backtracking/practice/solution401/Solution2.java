package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution401;

// 401. Binary Watch
//https://leetcode.com/problems/binary-watch/

/*

Easy

321

525

Favorite

Share


A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */

import java.util.ArrayList;
import java.util.List;

class Solution2 {
  // 2 ms, faster than 77.58%
  public List<String> readBinaryWatch(int num) {
    List<String> res = new ArrayList<>();
    backtracking(num, 0, "", res);
    return res;
  }

  // count: 代表当前已经使用的 1 的个数
  private void backtracking(int num, int count, String str, List<String> res) {
    if (10 - str.length() < num - count)
      return;
    if (count == num) {
      StringBuilder tmp = new StringBuilder(str);
      while (str.length() < 10)
        str += "0";
      int hour = Integer.valueOf(str.substring(0, 4), 2);
      int minute = Integer.valueOf(str.substring(4), 2);
      if (isValid(hour, minute))
        res.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
      return;
    }
    backtracking(num, count + 1, str + "1", res);
    backtracking(num, count, str + "0", res);
  }

  private boolean isValid(int hour, int minute) {
    if (hour > 11 || minute > 59)
      return false;
    return true;
  }
}