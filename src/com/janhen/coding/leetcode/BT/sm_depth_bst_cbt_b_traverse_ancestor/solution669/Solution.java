package com.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution669;

import com.janhen.leetcode.structures.TreeNode;

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val < L)
            return trimBST(root.right, L, R); // NOTE: remove cur node AND find
        if (root.val > R)
            return trimBST(root.left, L, R);
        // common to link
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}