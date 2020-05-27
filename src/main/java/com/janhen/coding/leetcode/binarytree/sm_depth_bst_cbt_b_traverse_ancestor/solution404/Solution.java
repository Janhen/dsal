package com.janhen.coding.leetcode.binarytree.sm_depth_bst_cbt_b_traverse_ancestor.solution404;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    // DLR, pre order traverse to collect left leave
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (isLeaf(root.left))
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);  // continue to searh
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }
}