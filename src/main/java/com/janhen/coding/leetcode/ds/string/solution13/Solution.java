package com.janhen.coding.leetcode.ds.string.solution13;

// 13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/

class Solution {

  // TODO
  // 58 ms, faster than 50.44%
  public int romanToInt(String s) {
    int sum = 0;
    if (s.lastIndexOf("IX") != -1) sum -= 2;
    if (s.lastIndexOf("IV") != -1) sum -= 2;
    if (s.lastIndexOf("XL") != -1) sum -= 20;
    if (s.lastIndexOf("XC") != -1) sum -= 20;
    if (s.lastIndexOf("CD") != -1) sum -= 200;
    if (s.lastIndexOf("CM") != -1) sum -= 200;

    char[] chs = s.toCharArray();
    for (char c : chs) {         // from high bit to low bit
      if (c == 'M') sum += 1000;
      if (c == 'D') sum += 500;
      if (c == 'C') sum += 100;
      if (c == 'L') sum += 50;
      if (c == 'X') sum += 10;
      if (c == 'V') sum += 5;
      if (c == 'I') sum += 1;
    }
    return sum;
  }
}