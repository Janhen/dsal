package com.janhen.coding.leetcode.ds.tree.quality.solution404;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionR {
    // DLR, pre order traverse to collect left leave
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);  // continue to searh
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}