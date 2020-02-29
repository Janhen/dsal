package com.janhen.swordoffer.tree.problem54;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.Stack;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0)
            return null;
        int cnt = 0;             // record now is cnt th
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = pRoot;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (++ cnt == k) return cur;    // preposition ++ to handle ...
            cur = cur.right;
        }
        return null;
    }
}
