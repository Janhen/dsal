package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution103;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    // use for record reversed order element
    boolean isRight = true;
    while (!queue.isEmpty()) {
      int cnt = queue.size();
      List<Integer> level = new ArrayList<>();
      while (cnt-- > 0) {
        TreeNode cur = queue.poll();
        level.add(cur.val);
        if (cur.left != null)
          queue.offer(cur.left);
        if (cur.right != null)
          queue.offer(cur.right);
      }
      if (isRight) {
        res.add(level);
      } else {
        Collections.reverse(level);
        res.add(level);
      }
      isRight = !isRight;
    }
    return res;
  }
}