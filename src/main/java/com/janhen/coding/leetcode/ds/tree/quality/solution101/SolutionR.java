package com.janhen.coding.leetcode.ds.tree.quality.solution101;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionR {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return true;
    if (t1 == null || t2 == null)
      return false;
    if (t1.val != t2.val)
      return false;
    return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
  }
}