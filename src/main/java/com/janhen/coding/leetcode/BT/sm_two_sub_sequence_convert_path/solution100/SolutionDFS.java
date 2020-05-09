package com.janhen.coding.leetcode.BT.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionDFS {
    // preOrder
    // only one stack
    // 3 ms, faster than 35.92%
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root1);
        s1.push(root2);
        while (!s1.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s1.pop();

            // equal to visit
            if (node1.val != node2.val)
                return false;

            if (node1.right != null) s1.push(node1.right);
            if (node2.right != null) s1.push(node2.right);
            if (s1.size() %2 != 0) return false;        // to prevent broken node,  all null OR or not null can continue

            if (node1.left != null) s1.push(node1.left);
            if (node2.left != null) s1.push(node2.left);
            if (s1.size() %2 != 0) return false;
        }
        return s1.isEmpty();
    }
}