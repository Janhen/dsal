package com.janhen.coding.leetcode.ds.tree.quality.solution513;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int findBottomLeftValue(TreeNode root) {
    TreeNode cur = null;
    // 1. like level traverse
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      cur = queue.poll();
      // 2. offer right and then left
      if (cur.right != null)
        queue.offer(cur.right);
      if (cur.left != null)
        queue.offer(cur.left);
    }
    // 3. return latest iterate node
    return cur.val;
  }
}