package com.janhen.coding.swordoffer.a_base.problem27;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.Stack;

public class Solution1 {
    // preOrder traverse
    public void Mirror(TreeNode root) {
        if (root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
