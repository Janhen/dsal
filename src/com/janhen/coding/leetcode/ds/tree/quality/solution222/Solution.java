package com.janhen.coding.leetcode.ds.tree.quality.solution222;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    // the properties of a complete binary tree
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int rightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}