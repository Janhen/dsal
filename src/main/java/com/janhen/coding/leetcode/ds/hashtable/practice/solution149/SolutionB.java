package com.janhen.coding.leetcode.ds.hashtable.practice.solution149;

// 149. Max Points on a Line
//https://leetcode.com/problems/max-points-on-a-line/
// hard 15.5%

/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */



class SolutionB {

  // https://www.jianshu.com/p/5432c35fbd44

  public int maxPoints(Point[] points) {
    // 边界：一共两个点你还判断个鸡毛共线
    final int len = points.length;
    if (len < 3) {
      return len;
    }

    int max = 0;
    for (int i = 0; i < len - 1; ++i) {
      for (int j = i + 1; j < len; ++j) {
        // points[i] 和 points[j]
        // 这里需要一个bool值的slope 来判断斜率是否存在，不存在的话设置为false,后续单独处理
        boolean slope = true;
        int dX = points[i].x - points[j].x;
        int dY = points[i].y - points[j].y;
        int interceptDX = 0;
        if (dX == 0) {
          // 这时候两个点连线是垂直于x轴的，木有斜率
          slope = false;
        } else {
          // 这个是点斜式的变形， 等式左侧是(截距*dx),自己在演算纸上验算一下吧,就不详细说了
          interceptDX = dX * points[i].y - dY * points[i].x;
        }

        int count = 0;
        for (int k = 0; k < len; ++k) {
          if (slope) {
            // 将k点的x和y带入看直线方程是否有解。
            if (interceptDX == dX * points[k].y - dY * points[k].x) {
              ++count;
            }
          } else {
            if (points[k].x == points[i].x) {
              ++count;
            }
          }
        }
        max = Math.max(max, count);
      }
    }

    return max;
  }
}