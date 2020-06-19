package com.janhen.coding.leetcode.tree.sm_two_sub_sequence_convert_path.solution114;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = new TreeNode(-1);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            pre.right = cur;
            // cut left pointer
            pre.left = null;
            pre = cur;
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
}