package com.janhen.coding.leetcode.ds.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution98;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;      // record to compare
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val < pre.val)
                return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}