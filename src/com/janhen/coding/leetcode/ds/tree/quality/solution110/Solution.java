package com.janhen.coding.leetcode.ds.tree.quality.solution110;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    // between calculate every tree node height to find
    // need to calculate all tree node height
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)  // judge in this every time
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}