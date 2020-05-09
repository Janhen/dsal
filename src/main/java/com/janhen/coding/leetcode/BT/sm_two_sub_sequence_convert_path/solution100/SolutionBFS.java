package com.janhen.coding.leetcode.BT.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionBFS {
    // BFS
    // size control
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        // complete node
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root1);
        q.offer(root2);
        while (!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();

            if (node1.val != node2.val)
                return false;

            if (node1.left != null) q.offer(node1.left);
            if (node2.left != null) q.offer(node2.left);
            if (q.size() % 2 != 0) return false;

            if (node1.right != null) q.offer(node1.right);
            if (node2.right != null) q.offer(node2.right);
            if (q.size() % 2 != 0) return false;
        }
        return true;
    }
}