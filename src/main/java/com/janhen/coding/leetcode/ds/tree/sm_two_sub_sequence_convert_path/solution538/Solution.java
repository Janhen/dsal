package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution538;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {

  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) return null;
    traverseRDL(root);
    return root;
  }

  // BST greater => 中序遍历的反面
  // LDR => RDL
  private void traverseRDL(TreeNode node) {
    if (node == null)
      return;
    traverseRDL(node.right);
    sum += node.val;
    node.val = sum;
    traverseRDL(node.left);
  }
}