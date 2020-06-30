package com.janhen.coding.leetcode.ds.tree.quality.solution230;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionF {
  // continue to narrow tree scale
  public int kthSmallest(TreeNode root, int k) {
    int leftSize = count(root.left);
    if (leftSize == k - 1)
      return root.val;
    else if (leftSize > k - 1)
      return kthSmallest(root.left, k);   // left is big enough
    else
      return kthSmallest(root.right, k - leftSize - 1);   // left insufficient
  }

  private int count(TreeNode node) {
    if (node == null) return 0;
    return 1 + count(node.left) + count(node.right);
  }
}