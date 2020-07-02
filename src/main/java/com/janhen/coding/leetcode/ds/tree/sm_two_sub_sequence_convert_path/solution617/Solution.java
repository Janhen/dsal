package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution617;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    // 1. terminal condition
    if (t1 == null)
      return t2;
    if (t2 == null)
      return t1;
    // 2. handle case: two nodes, other to link
    TreeNode root = new TreeNode(t1.val + t2.val);
    // 3. continue to recursive
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;
  }
}