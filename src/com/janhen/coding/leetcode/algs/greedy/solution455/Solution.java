package com.janhen.coding.leetcode.algs.greedy.solution455;

import java.util.Arrays;

class Solution {
  /*
   * 题目描述：每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
   *
   * 给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。
   * 因为最小的孩子最容易得到满足，所以先满足最小的孩子。
   *
   * 证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，
   * 第 m 个饼干为可以满足该孩子的最小饼干。
   * 假设存在一种最优策略，给该孩子分配第 n 个饼干，并且 m < n。
   * 我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。
   * 因此在后续的分配中，贪心策略一定能满足更多的孩子。
   * 也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
   * @param g       孩子所对应的满意度
   * @param s       饼干的满意度
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int gi = g.length - 1, si = s.length - 1;
    int res = 0;
    while (gi >= 0 && si >= 0) {
      if (s[si] >= g[gi]) {
        res++;
        si--;
        gi--;
      } else
        gi--;
    }
    return res;
  }
}
