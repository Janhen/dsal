package com.janhen.coding.leetcode.ds.tree.quality.solution94;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null)
      return res;

    // 1. init node
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    // 2. LDR iterate leftest node
    while (cur != null || !stack.isEmpty()) {
      // collect all left edge tree node
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      // pop first is leftest tree node
      cur = stack.pop();
      res.add(cur.val);
      cur = cur.right;
    }
    return res;
  }
}
