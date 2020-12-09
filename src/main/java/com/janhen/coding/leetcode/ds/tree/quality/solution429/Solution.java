package com.janhen.coding.leetcode.ds.tree.quality.solution429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    // 1. init queue and put root node
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      // 2. iterate level element and collect result
      List<Integer> level = new LinkedList<>();
      int cnt = queue.size();
      for (int i = 0; i < cnt; i++) {
        Node node = queue.poll();
        level.add(node.val);
        // 3. put next level node in queue
        for (Node child : node.children)
          queue.offer(child);
      }
      res.add(level);
    }
    return res;
  }
}
