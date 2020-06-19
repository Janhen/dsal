package com.janhen.coding.leetcode.other.topinterview.solution50;

public class Solution3 {

  /*
recursion, power reduction; binary，O(logn)
1. n is a positive even number, such as n=4, that is, 2^4=2*2*2*2, which can be disassembled as (2*2)^(n/2)
2. n is a positive odd number, such as n=3, that is, 2^3=2*2*2, which can be disassembled as 2*((2*2)^(n-1/2))
note:
when n is a negative number, the  recursion is  1/(myPow(x,-n)),
but if n is 2^31-1,  the  -n  will overflow, so use -(n+1) to avoid this and then multiply Just once x to maintain we didnt change the number
*/
  public double myPow(double x, int n) {
    if (n == 0) return 1.0;

    if (n < 0) {
      return 1 / (x * myPow(x, -(n + 1)));
    }

    if ((n & 1) == 0) { // n is even
      return myPow(x * x, n / 2);
    } else { // odd
      return x * myPow(x * x, (n - 1) / 2);
    }
  }
}
