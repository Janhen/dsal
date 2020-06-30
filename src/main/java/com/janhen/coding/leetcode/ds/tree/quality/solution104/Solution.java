package com.janhen.coding.leetcode.ds.tree.quality.solution104;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return 1 + Math.max(leftDepth, rightDepth);
  }
}


