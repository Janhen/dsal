package com.janhen.coding.leetcode.algs.greedy.solution406;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
  public class People {
    public int height;
    public int k;
    public int idx;   //index of this people in people[][]

    public People(int h, int k, int i) {
      this.height = h;
      this.k = k;
      this.idx = i;
    }
  }

  public int[][] reconstructQueue(int[][] people) {
    if (people.length == 0)
      return new int[0][0];

    PriorityQueue<People> pq = new PriorityQueue<>((p1, p2) ->
      (p1.height != p2.height ? p2.height - p1.height : p1.k - p2.k));
    for (int i = 0; i < people.length; i++) {
      pq.add(new People(people[i][0], people[i][1], i));
    }

    List<Integer> list = new ArrayList<>();
    while (!pq.isEmpty()) {
      People p = pq.poll();
      // p.k表示前面有几个人比它高，所以要插入在第k个位置
      list.add(p.k, p.idx);
    }

    // 根据原始数据返回结果
    int[][] res = new int[people.length][2];
    for (int i = 0; i < list.size(); i++) {
      res[i][0] = people[list.get(i)][0];
      res[i][1] = people[list.get(i)][1];
    }
    return res;
  }
//  public static void main(String[] args) {
//    int[][] a = new int[6][2];
//    a[0] = new int[]{7, 0};
//    a[1] = new int[]{4, 4};
//    a[2] = new int[]{7, 1};
//    a[3] = new int[]{5, 0};
//    a[4] = new int[]{6, 1};
//    a[5] = new int[]{5, 2};
//    new Solution2().reconstructQueue(a);
//  }
}
