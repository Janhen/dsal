package com.janhen.coding.swordoffer.a_good.problem36;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.Stack;

public class Solution {
    // LDR, need right to traverse THEN right as next pointer, left as prev pointer
    public TreeNode Convert(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {     // traverse util NULL
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            // logic handle
            if (pre == null) {
                pre = cur;
                root = cur;
                root.left = null;   // as head
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }

            cur = cur.right;
        }
        return root;
    }
}
