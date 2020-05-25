package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionDFS3 {
    // preOrder
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

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

            // put right and check
            if (node1.right != null && node2.right != null) { // complete
                s1.push(node1.right);
                s2.push(node2.right);
            }
            else if (node1.right == null && node2.right == null) {} // leaf          continue skip loop
            else                    // broken
                return false;

            // put left and check
            if (node1.left != null && node2.left != null) {
                s1.push(node1.left);
                s2.push(node2.left);
            }
            else if (node1.left == null && node2.left == null) {}
            else // number not match
                return false;
        }
        // same empty
        return s1.size() == s2.size();
    }
}