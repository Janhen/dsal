package com.janhen.coding.leetcode.tree.solution589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
589. N-ary Tree Preorder Traversal
Easy

516

56

Add to List

Share
Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Follow up:

Recursive solution is trivial, could you do it iteratively?



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
class SolutionF {
  public List<Integer> preorder(Node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<Node> s = new Stack<>();
    s.push(root);
    while (!s.isEmpty()) {
      Node node = s.pop();
      list.add(node.val);
      for (int i = node.children.size() - 1; i >= 0; i --) {
        s.push(node.children.get(i));
      }
    }
    return list;
  }
}