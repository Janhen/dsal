package com.janhen.coding.leetcode.ds.tree.quality.solution235;

import com.janhen.coding.leetcode.structures.TreeNode;

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;

    if (p.val < root.val && q.val < root.val)
      return lowestCommonAncestor(root.left, p, q);
    if (p.val > root.val && q.val > root.val)
      return lowestCommonAncestor(root.right, p, q);
    return root;
  }
}
