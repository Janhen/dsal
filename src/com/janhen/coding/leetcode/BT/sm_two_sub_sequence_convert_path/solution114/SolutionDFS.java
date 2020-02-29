package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution114;

import com.janhen.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionDFS {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

            if (!stack.isEmpty()) cur.right = stack.peek();     // pre
            cur.left = null;
        }
    }
}