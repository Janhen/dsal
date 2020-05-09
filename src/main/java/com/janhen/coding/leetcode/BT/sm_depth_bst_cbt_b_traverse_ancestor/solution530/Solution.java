package com.janhen.coding.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution530;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (pre != null)
            minDiff = Math.min(minDiff, node.val - pre.val);   // compare minDiff AND cur diff
        pre = node;
        inOrder(node.right);
    }
}