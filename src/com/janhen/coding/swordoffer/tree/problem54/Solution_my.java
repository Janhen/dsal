package com.janhen.swordoffer.tree.problem54;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.Stack;

public class Solution_my {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 0)
            return null;
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while (cur != null || !stack.isEmpty()) {        // NOTE: no need push root in stack before
            while (cur != null) {     // need to traverse all left node
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (++ cnt == k) {
                return cur;
            }
            cur = cur.right;
        }
        return null;
    }
}
