package com.janhen.coding.swordoffer.tree.problem54;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.Stack;

public class Solution {
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k < 0) {
            return null;
        }
        int cnt = 0;             // record now is cnt th
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (++ cnt == k) {
                return cur;    // preposition ++ to handle ...
            }
            cur = cur.right;
        }
        return null;
    }
}
