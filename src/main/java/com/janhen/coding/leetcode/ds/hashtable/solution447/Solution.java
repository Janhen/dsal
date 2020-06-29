package com.janhen.coding.leetcode.ds.hashtable.solution447;

import java.util.HashMap;
import java.util.Map;

class Solution {
  // 复用给一个 HashMap, 其 clear() 方法保留原来的数组大小，可避免进行扩容
  // 157 ms, faster than 37.98%
  // time : O(N^2)
  // space : O(N) 每次创建之后便释放, all n(n-1)
  // dis(A,B) = dis(A,C) = dis(A,D) = dis(A,E)
  // three tuple: (A, X, Y) X=C(n,1), Y=C(n-1,1) ⇒ total C(n,2)

  // x^2 + y^2
  // key distance
  // val frequency
  // (x,y,z)
  // distance(x,y) == distance(x,z)
  public int numberOfBoomerangs(int[][] points) {
    int res = 0;
    for (int i = 0; i < points.length; i++) {
      // distance -> frequency
      Map<Integer, Integer> freqs = new HashMap<>(); // current point x, every point ↔ record
      for (int j = 0; j < points.length; j++) {
        if (j != i) {
          int distance = distance(points[i], points[j]);
          freqs.put(distance, freqs.getOrDefault(distance, 0) + 1); // collect all distance(x,y)
        }
      }
      // collect result
      // if 1 1 * 0 can hidden
      for (int key : freqs.keySet()) // insure x, find {y,z}
        if (freqs.get(key) >= 2)
          res += freqs.get(key) * (freqs.get(key) - 1); // C(n,2) = freq*(freq-1)
    }
    return res;
  }

  // x² + y²
  private int distance(int[] A, int[] B) {
    return (A[0] - B[0]) * (A[0] - B[0]) + (A[1] - B[1]) * (A[1] - B[1]);
  }
}
