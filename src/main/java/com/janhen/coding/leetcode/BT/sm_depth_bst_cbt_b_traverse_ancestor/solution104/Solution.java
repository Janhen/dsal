package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution104;

import main.java.janhen.leetcode.structures.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}


