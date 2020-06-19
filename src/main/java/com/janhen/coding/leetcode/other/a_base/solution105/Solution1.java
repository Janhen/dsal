package com.janhen.coding.leetcode.a_base.solution105;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution1 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
      return null;
    return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
    if (preL > preR || inL > inR) return null;

    TreeNode root = new TreeNode(preorder[preL]);
    for (int i = inL; i <= inR; i++) {
      if (inorder[i] == root.val) {     // find first R index
        root.left = buildTree(preorder, preL + 1, preL + (i - inL), inorder, inL, i - 1);   // [inL,i-1] ⇔ [inL, inL+(i-inL)]
        root.right = buildTree(preorder, preL + (i - inL) + 1, preR, inorder, i + 1, inR);
        break;
      }
    }
    return root;
  }
}