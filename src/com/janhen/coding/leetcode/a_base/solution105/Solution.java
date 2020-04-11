package com.janhen.leetcode.a_base.solution105;

import com.janhen.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

  Map<Integer, Integer> inorderNumIndex = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

    for (int i = 0; i < inorder.length; i++)
      inorderNumIndex.put(inorder[i], i);
    return buildTree(preorder, 0, preorder.length - 1, 0);
  }

  private TreeNode buildTree(int[] preorder, int preL, int preR, int inL) {
    if (preL > preR) return null;

    TreeNode root = new TreeNode(preorder[preL]);
    int index = inorderNumIndex.get(root.val);
    int leftSize = index - inL;
    root.left = buildTree(preorder, preL + 1, preL + leftSize, inL);
    root.right = buildTree(preorder, preL + leftSize + 1, preR, index + 1);
    return root;
  }
}