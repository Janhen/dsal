package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution114;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionRef {
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        node.right = pre;
        node.left = null;
        pre = node;
    }
}