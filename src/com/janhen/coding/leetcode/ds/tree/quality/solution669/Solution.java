package com.janhen.coding.leetcode.ds.tree.quality.solution669;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        // trim left tree
        if (root.val < L)
            return trimBST(root.right, L, R); // NOTE: remove cur node AND find

        // trim right tree
        if (root.val > R)
            return trimBST(root.left, L, R);

        // not need trim, common to link
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}