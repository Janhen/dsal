package com.janhen.coding.leetcode.binarytree.solution590;

/*
590. N-ary Tree Postorder Traversal
Easy

575

61

Add to List

Share
Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Follow up:

Recursive solution is trivial, could you do it iteratively?



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]


Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
Accepted
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SolutionF {

  public List<Integer> postorder(Node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    // LRD -> DRL reverse
    while(!stack.isEmpty()) {
      root = stack.pop();
      list.add(root.val);

      for(Node node: root.children)
        stack.add(node);
    }
    Collections.reverse(list);
    return list;
  }
}
