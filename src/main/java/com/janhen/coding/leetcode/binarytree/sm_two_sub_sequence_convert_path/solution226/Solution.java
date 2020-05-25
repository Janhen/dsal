package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution226;

import com.janhen.coding.leetcode.structures.TreeNode;

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