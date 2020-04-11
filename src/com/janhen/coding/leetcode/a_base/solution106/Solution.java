package com.janhen.leetcode.a_base.solution106;

import com.janhen.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

  Map<Integer, Integer> inorderNumIndex = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++)
      inorderNumIndex.put(inorder[i], i);

    return buildTree(0, postorder, 0, postorder.length - 1);
  }

  private TreeNode buildTree(int inL, int[] postorder, int postL, int postR) {
    if (postL > postR) return null;

    TreeNode root = new TreeNode(postorder[postR]);
    int index = inorderNumIndex.get(root.val);
    int leftSize = index - inL;
    root.left = buildTree(inL, postorder, postL, postL + leftSize - 1);
    root.right = buildTree(index + 1, postorder, postL + leftSize, postR - 1);
    return root;
  }
}