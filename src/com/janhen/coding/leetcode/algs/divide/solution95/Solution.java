package com.janhen.coding.leetcode.algs.divide.solution95;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new LinkedList<TreeNode>();
    }
    return generateSubtrees(1, n);
  }

  private List<TreeNode> generateSubtrees(int start, int end) {
    List<TreeNode> res = new LinkedList<>();
    if (start > end) {
      res.add(null);
      return res;
    }
    for (int i = start; i <= end; ++i) {
      List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
      List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
      for (TreeNode left : leftSubtrees) {
        for (TreeNode right : rightSubtrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }
}
