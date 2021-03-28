package com.janhen.coding.leetcode.ds.stackqueue.monotonousstack.solution556;

import java.util.Arrays;

public class Solution {

  // O(N)time O(N)space
  // N is String.valueOf(n)'s length
  public int nextGreaterElement(int n) {
    // 2^32 < 10^10
    int[] t = new int[10];
    int l = t.length;
    int temp = n;
    // chang n as array
    while (l > 0 && temp > 0) {
      l--;
      t[l] = temp % 10;
      temp /= 10;
    }
    for (int i = t.length - 1; i > l; i--) {
      if (t[i] > t[i - 1]) {
        // find the index which is bigger than front one
        int tempIndex = i;
        // find the min one who is bigger than t[i-1]
        for (int j = i; j < t.length; j++) {
          if (t[j] > t[i - 1] && t[j] < t[tempIndex]) {
            tempIndex = j;
          }
        }
        // change t[i -1] t[tempIndex]
        temp = t[i - 1];
        t[i - 1] = t[tempIndex];
        t[tempIndex] = temp;
        // get the element after i - 1
        int[] arr = new int[t.length - i];
        System.arraycopy(t, i, arr, 0, t.length - i);
        // sort
        Arrays.sort(arr);
        // copy arr to t[i] - t[len-1]
        System.arraycopy(arr, 0, t, i, arr.length);
        break;
      }
    }
    // get the new number
    int res = 0;
    for (int i : t) {
      res = res * 10 + i;
    }
    // if the new one is bigger the n return it or return -1
    return res <= n ? -1 : res;
  }
}
