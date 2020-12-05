package com.janhen.coding.leetcode.ds.string.solution38;

// 38. Count and Say
//https://leetcode.com/problems/count-and-say/
// easy

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */


import java.util.ArrayList;
import java.util.List;

class Solution {

  // use for record all possible value
  private String[] memo;

  public Solution() {
    memo = new String[30 + 1];
    memo[1] = "1";
    for (int i = 2; i <= 30; i++) {
      memo[i] = genStrByPre(memo[i - 1]);
    }
  }

  // 1211
  // original order and frequency record, can have duplicated element   ⇒  List
  // todo
  private String genStrByPre(String str) {
    List<Pari> freqs = new ArrayList<>();
    freqs.add(new Pari(str.charAt(0), 1));
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1))
        freqs.get(freqs.size() - 1).count++;
      else
        freqs.add(new Pari(str.charAt(i), 1));
    }

    StringBuilder sb = new StringBuilder();
    for (Pari pari : freqs) {
      sb.append(pari.count);
      sb.append(pari.val);
    }
    return sb.toString();
  }

  class Pari {
    char val;
    int count;

    Pari(char v, int c) {
      val = v;
      count = c;
    }
  }

  // use same object to invoke this method optimize
  // 18 ms, faster than 20.42%
  public String countAndSay(int n) {
    return memo[n];
  }
}