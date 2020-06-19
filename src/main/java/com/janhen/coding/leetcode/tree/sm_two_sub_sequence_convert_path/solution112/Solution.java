package com.janhen.coding.leetcode.tree.sm_two_sub_sequence_convert_path.solution112;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        // judge leave node
        if (root.left == null && root.right == null)
            return root.val == sum;
        // find in left and right subtree
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}