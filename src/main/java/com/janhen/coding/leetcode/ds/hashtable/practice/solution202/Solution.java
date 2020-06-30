package com.janhen.coding.leetcode.ds.hashtable.practice.solution202;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isHappy(int n) {
    int cur = n;
    // record to prevent loop
    Set<Integer> record = new HashSet<>();
    while (cur != 1) {
      cur = getDigitSquare(cur);
      if (!record.contains(cur))
        record.add(cur);
      else           // in this have loop
        return false;
    }
    return true;
  }

  private int getDigitSquare(int n) {
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      sum += digit * digit;
      n = n / 10;
    }
    return sum;
  }
}