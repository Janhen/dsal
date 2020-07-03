package com.janhen.coding.leetcode.algs.greedy.solution452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  // 计算不重叠的区间个数
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
    int cnt = 1, end = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= end) {
        continue;
      }
      cnt++;
      end = points[i][1];
    }
    return cnt;
  }
}
