package com.janhen.coding.leetcode.ds.tree.quality.solution671;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null)
      return -1;
    if (root.left == null && root.right == null)
      return -1;

    // skip duplication
    int leftVal = root.left.val;
    int rightVal = root.right.val;
    if (leftVal == root.val)
      leftVal = findSecondMinimumValue(root.left);
    if (rightVal == root.val)
      rightVal = findSecondMinimumValue(root.right);

    if (leftVal != -1 && rightVal != -1)
      return Math.min(leftVal, rightVal);    // not BST
    return leftVal != -1 ? leftVal : rightVal;   // one or all duplication with current node
  }
}