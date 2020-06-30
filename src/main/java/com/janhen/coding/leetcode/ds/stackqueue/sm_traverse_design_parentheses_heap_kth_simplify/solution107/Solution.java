package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution107;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int cnt = queue.size();
      List<Integer> level = new ArrayList<>();
      while (cnt-- > 0) {
        TreeNode front = queue.poll();
        level.add(front.val);
        if (front.left != null)
          queue.offer(front.left);
        if (front.right != null)
          queue.offer(front.right);
      }
      res.add(level);
    }
    Collections.reverse(res);
    return res;
  }
}