package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution114;

import com.janhen.coding.leetcode.structures.TreeNode;

// todo QQ
class SolutionR {
    public void flatten(TreeNode root) {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null)
            return;

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;

        postOrder(left);
        postOrder(right);

        node.right = left;
        TreeNode rightest = rightestNode(node);
        rightest.right = right;
    }

    private TreeNode rightestNode(TreeNode node) {
        TreeNode cur = node;
        while (cur.right != null) cur = cur.right;
        return cur;
    }
}