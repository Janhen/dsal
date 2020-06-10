package com.janhen.coding.leetcode.a_base.solution105;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

  // inOrderNum -> index
  private Map<Integer, Integer> inorderNumIndex = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
      return null;

    // init inorder val -> index map
    for (int i = 0; i < inorder.length; i++)
      inorderNumIndex.put(inorder[i], i);

    return buildTree(preorder, 0, preorder.length - 1, 0);
  }

  // [preL, preR] to build tree
  // inL:   from in order begin index
  private TreeNode buildTree(int[] preorder, int preL, int preR, int inL) {
    if (preL > preR)
      return null;

    // pre order DLR, to build current root node
    TreeNode root = new TreeNode(preorder[preL]);

    //  L ... L D R ... R
    //  ^       ^
    // inL     index
    //  D L ... L R ... R
    //  ^
    // preL

    int index = inorderNumIndex.get(root.val);
    int leftSize = index - inL;

    // build left subtree and right subtree
    root.left = buildTree(preorder, preL + 1, preL + leftSize, inL);
    root.right = buildTree(preorder, preL + leftSize + 1, preR, index + 1);
    return root;
  }
}