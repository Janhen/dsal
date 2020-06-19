package com.janhen.coding.leetcode.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution543;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}