package com.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution404;

// 404. Sum of Left Leaves
//https://leetcode.com/problems/sum-of-left-leaves/

import com.janhen.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionBfs {
    // node.left !=null AND node.left is leaf
    // 左叶子的性质求解
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left!= null && node.left.left == null && node.left.right == null)  // node.left is left leaves
                res += node.left.val;
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        return res;
    }
}