package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution124;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // get 每个节点添加最大路径和属性
    private int helper(TreeNode node) {
        // 1. terminal condition
        if (node == null)
            return 0;
        // 2. node max path sum that from cur node to leaf node
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        // 3. collect result
        max = Math.max(max, node.val + left + right);
        // 4. continue to calculate node max path sum
        return node.val + Math.max(left, right);
    }
}