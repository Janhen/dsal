package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution145;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Using a tag to record whether the node has been visited

class SolutionRef2 {

  private class TagNode {
    TreeNode node;
    boolean isFirst;

    TagNode(TreeNode node) {
      this.node = node;
      this.isFirst = false;
    }
  }

  // todo Q
  // modify object attribute to reduce object create cost
  public List<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null)
      return res;

    Stack<TagNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.push(new TagNode(cur));
        cur = cur.left;
      }

      TagNode tagNode = stack.pop();
      cur = tagNode.node;
      if (!tagNode.isFirst) {
        tagNode.isFirst = true;
        stack.push(tagNode);   // pop and push    only modify attribute
        cur = cur.right;
      } else {
        res.add(cur.val);
        cur = null;
      }
    }
    return res;
  }
}
