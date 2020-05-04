package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution110;

import main.java.janhen.leetcode.structures.TreeNode;

class Solution {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)  // judge in this every time
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}