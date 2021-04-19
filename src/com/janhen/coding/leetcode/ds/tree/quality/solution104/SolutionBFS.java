package com.janhen.coding.leetcode.ds.tree.quality.solution104;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionBFS {
    // BFS : level traversal
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            level++;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return level;
    }
}


