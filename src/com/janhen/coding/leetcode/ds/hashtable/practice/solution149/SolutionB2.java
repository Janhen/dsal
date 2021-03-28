package com.janhen.coding.leetcode.ds.hashtable.practice.solution149;


import java.util.HashMap;
import java.util.Map;

class SolutionB2 {

  // https://www.jianshu.com/p/5432c35fbd44


  public int maxPoints(Point[] points) {
    // 同上
    final int len = points.length;
    if (len < 3) {
      return len;
    }

    int max = 0;
    // 创建一个hash表来存储斜率对应的点的数量。
    Map<Double, Integer> map = new HashMap<>();
    for (int i = 0; i <= len - 2; ++i) {
      map.clear();
      int samePoint = 0;// 与pi 重合的点
      int sameLine = 1;// 和pi共线的最大点数
      for (int j = i + 1; j <= len - 1; ++j) {
        Double slope = null;
        if (points[i].x == points[j].x) {
          // 垂直与x轴的情况
          slope = Double.POSITIVE_INFINITY;
          // 重合的点
          if (points[i].y == points[j].y) {
            ++samePoint;
            continue;
          }
        } else {
          if (points[i].y == points[j].y) {
            // 这个涉及一个 -0 和 +0的问题， 在float和double里，+0是大于-0的，这个跟小数的实现有关系，有兴趣自行查一下
            slope = 0.0;
          } else {
            // 求斜率
            slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
          }
        }

        Integer slopeCount = map.get(slope);
        if (slopeCount != null) {
          map.put(slope, slopeCount + 1);
          slopeCount += 1;
        } else {
          slopeCount = 2;
          map.put(slope, slopeCount);
        }

        sameLine = Math.max(sameLine, slopeCount);
      }
      // 共线的点加上重合的点
      max = Math.max(max, sameLine + samePoint);
    }

    return max;
  }
}