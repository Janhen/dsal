package com.janhen.coding.leetcode.ds.tree.quality.solution589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class SolutionF {
  public List<Integer> preorder(Node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    // 1. put root node
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    // 2. iterate DLR => DRL
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      list.add(node.val);
      for (int i = node.children.size() - 1; i >= 0; i --) {
        stack.push(node.children.get(i));
      }
    }
    return list;
  }
}