package com.janhen.coding.leetcode.BT.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionBFS2 {
    // BFS
    // leaf, broken, complete, logic
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

            // handle null
            if (node1 == null && node2 == null) // leaf
                continue;
            else if (node1 == null || node2 == null ||
                    node1.val != node2.val) // broken or not match
                return false;

            // all complete node
            q.offer(node1.left);
            q.offer(node2.left);
            q.offer(node1.right);
            q.offer(node2.right);
        }
        return true;
    }
}