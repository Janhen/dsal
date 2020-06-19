package com.janhen.coding.leetcode.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution543;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionRef {
    // Probability analysis :
    // P1 : 左树的最远距离
    // P2 : 右树的最远距离
    // P3 : 经过当前 x 节点的最远距离,  根据 左树的最远距离, 和右树的最远距离, 求出其最远距离

    // message body :
    // distance
    // h  :  左树 or 右树上节点到当前的最远
    // 每个节点都添加维度属性，从左树和右树最大维度中选择，同时当前节点的最大维度进行选择
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int curData = height(root.left) + height(root.right);
        int leftData = diameterOfBinaryTree(root.left);
        int rightData = diameterOfBinaryTree(root.right);
        return Math.max(curData, Math.max(leftData, rightData));
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}