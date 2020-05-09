package com.janhen.coding.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution101;

//101. Symmetric Tree
//        https://leetcode.com/problems/symmetric-tree/description/

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionDFS {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root.left, root.right));
        TreeNode left, right;
        while (!s.isEmpty()) {
            left = s.peek().node1;
            right = s.pop().node2;
            if (left == null && right == null) continue;
            else if (left == null || right == null) return false;
            else if (left.val != right.val) return false;
            s.push(new Pair(left.left, right.right));
            s.push(new Pair(left.right, right.left));
        }
        return true;
    }

    public class Pair {
        public TreeNode node1;
        public TreeNode node2;

        public Pair(TreeNode node1, TreeNode node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }
}