package com.janhen.coding.leetcode.other.a_base.solution105;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Arrays;

class Solution2 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

    TreeNode root = new TreeNode(preorder[0]);
    int firstRIndex = 0;
    for (; firstRIndex < inorder.length && inorder[firstRIndex] != preorder[0]; firstRIndex++) ;

    root.left = buildTree(Arrays.copyOfRange(preorder, 1, firstRIndex + 1), Arrays.copyOfRange(inorder, 0, firstRIndex));
    root.right = buildTree(Arrays.copyOfRange(preorder, firstRIndex + 1, preorder.length), Arrays.copyOfRange(inorder, firstRIndex + 1, inorder.length));
    return root;
  }
}