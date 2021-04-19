package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution687;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    int maxPathLen = 0;

    // TODO
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        getMaxDuplicationPathLength(root);
        return maxPathLen;
    }

    private int getMaxDuplicationPathLength(TreeNode node) {
        if (node == null)
            return 0;

        int leftLen = getMaxDuplicationPathLength(node.left);
        int rightLen = getMaxDuplicationPathLength(node.right);
        int left = (node.left != null && node.left.val == node.val ? leftLen + 1 : 0);
        int right = (node.right != null && node.right.val == node.val ? rightLen + 1 : 0);
        maxPathLen = Math.max(maxPathLen, left + right);
        return Math.max(left, right);
    }
}