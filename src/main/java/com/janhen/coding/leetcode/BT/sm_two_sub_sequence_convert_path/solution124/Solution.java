package main.java.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution124;

import main.java.janhen.leetcode.structures.TreeNode;

class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));

        max = Math.max(max, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}