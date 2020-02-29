package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution226;

import com.janhen.leetcode.structures.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}