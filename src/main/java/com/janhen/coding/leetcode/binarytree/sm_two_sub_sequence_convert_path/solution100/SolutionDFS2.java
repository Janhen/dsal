package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionDFS2 {
    // preOrder
    // control size to implement
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();

            // equal to visit
            if (node1.val != node2.val)
                return false;

            if (node1.right != null) s1.push(node1.right);
            if (node2.right != null) s2.push(node2.right);
            if (s1.size() != s2.size()) return false;           // must same size when left or right respectively to join

            if (node1.left != null) s1.push(node1.left);
            if (node2.left != null) s2.push(node2.left);
            if (s1.size() != s2.size()) return false;
        }
        // is same empty?
        return s1.size() == s2.size();
    }
}