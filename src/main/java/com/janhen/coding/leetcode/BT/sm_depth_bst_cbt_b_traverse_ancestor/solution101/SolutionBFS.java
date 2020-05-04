package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution101;

//101. Symmetric Tree
//        https://leetcode.com/problems/symmetric-tree/description/

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionBFS {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);     // like two tree to traverse
        TreeNode left, right;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            left = q1.poll();
            right = q2.poll();
            if (left == null && right == null) continue;
            else if (left == null || right == null) return false;
            else if (left.val != right.val) return false;
            q1.offer(left.left);
            q2.offer(right.right);
            q1.offer(left.right);
            q2.offer(right.left);
        }
        return true;
    }
}