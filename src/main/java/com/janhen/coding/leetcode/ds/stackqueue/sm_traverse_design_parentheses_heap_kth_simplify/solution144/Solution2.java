package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution144;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
  public static final boolean GO = true;
  public static final boolean PRINT = false;

  private class Command {
    boolean op;
    TreeNode node;

    Command(boolean s, TreeNode n) {
      this.op = s;
      node = n;
    }
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null)
      return res;
    Stack<Command> stack = new Stack<>();
    stack.push(new Command(GO, root));
    while (!stack.isEmpty()) {
      Command cmd = stack.pop();
      if (cmd.op == PRINT)
        res.add(cmd.node.val);
      else {
        if (cmd.node.right != null)
          stack.push(new Command(GO, cmd.node.right));
        if (cmd.node.left != null)
          stack.push(new Command(GO, cmd.node.left));
        stack.push(new Command(PRINT, cmd.node));
      }
    }
    return res;
  }
}