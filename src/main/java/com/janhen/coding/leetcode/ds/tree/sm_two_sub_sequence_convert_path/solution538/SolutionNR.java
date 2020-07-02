package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution538;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionNR {
  public TreeNode convertBST(TreeNode root) {
    if (root == null) return null;

    int sum = 0;
    Stack<TreeNode> stack = new Stack();
    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.right;                       // Tree 的 RDL 遍历方式
      }
      cur = stack.pop();
      cur.val += sum;
      sum = cur.val;
      cur = cur.left;
    }
    return root;
  }
}