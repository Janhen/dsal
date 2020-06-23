package com.janhen.coding.leetcode.ds.hashtable.solution447;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/
// easy
// hash table

// Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
// such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
//
//Find the number of boomerangs.
// You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
//
//Example:
//Input:
//[[0,0],[1,0],[2,0]]
//
//Output:
//2
//
//Explanation:
//The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

import java.util.HashMap;
import java.util.Map;

class Solution1 {
  // clear
  // not new Object in loop
  // 155 ms, faster than 39.14%
  // time : O(N^2)
  // space : O(N) 每次创建之后便释放, all n(n-1)
  public int numberOfBoomerangs(int[][] points) {

    int res = 0;
    Map<Integer, Integer> record = new HashMap<>();
    for (int i = 0; i < points.length; i++) {
      int[] point = points[i];
      for (int j = 0; j < points.length; j++) {
        if (j != i) {
          int dis = distance(point, points[j]);
          record.put(dis, record.getOrDefault(dis, 0) + 1);
        }
      }
      for (int dis : record.keySet()) {
        if (record.get(dis) >= 2) {
          res += record.get(dis) * (record.get(dis) - 1);
        }
      }
      record.clear();
    }
    return res;
  }

  private int distance(int[] A, int[] B) {
    return (A[0] - B[0]) * (A[0] - B[0]) + (A[1] - B[1]) * (A[1] - B[1]);
  }
}
