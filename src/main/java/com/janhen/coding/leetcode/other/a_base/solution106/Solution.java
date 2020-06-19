package com.janhen.coding.leetcode.a_base.solution106;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

  private Map<Integer, Integer> inorderNumIndex = new HashMap<>();

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++)
      inorderNumIndex.put(inorder[i], i);

    return buildTree(postorder, 0, postorder.length - 1, 0);
  }

  private TreeNode buildTree(int[] postorder, int postL, int postR, int inL) {
    if (postL > postR) return null;

    // LRD
    // L L L D R R R R
    // L L L R R R R D

    TreeNode root = new TreeNode(postorder[postR]);
    int index = inorderNumIndex.get(root.val);
    // left tree node size
    int leftSize = index - inL;


    root.left = buildTree(postorder, postL, postL + leftSize - 1, inL);
    root.right = buildTree(postorder, postL + leftSize, postR - 1, index + 1);
    return root;
  }
}