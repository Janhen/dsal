package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution111;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    // dfs to traverse
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0)         // one tree have no node
            return left + right + 1;
        return 1+ Math.min(left, right);     // include cur node
    }
}