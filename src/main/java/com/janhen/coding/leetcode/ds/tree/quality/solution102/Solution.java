package com.janhen.coding.leetcode.ds.tree.quality.solution102;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int cnt = queue.size();
      // collect current layer left and right node
      List<Integer> layer = new ArrayList<>();
      while (cnt-- > 0) {
        TreeNode cur = queue.poll();
        layer.add(cur.val);
        if (cur.left != null)
          queue.offer(cur.left);
        if (cur.right != null)
          queue.offer(cur.right);
      }
      res.add(layer);   // container as element
    }
    return res;
  }
}