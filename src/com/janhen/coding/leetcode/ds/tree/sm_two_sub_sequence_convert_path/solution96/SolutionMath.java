package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution96;

// 96. Unique Binary Search Trees
//https://leetcode.com/problems/unique-binary-search-trees/

/*
 * ⇔ 给定BST 中序遍历序列, 有多少种可能的BST
 * https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 *
 */
class SolutionMath {
  int numTrees(int n) {
    //cantalan树
    //C(2n,n)/(n+1)
    long ans = 1;
    for (int i = n + 1; i <= 2 * n; i++) {
      ans = ans * i / (i - n);
    }
    return (int) (ans / (n + 1));
  }
}