package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution145;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        // 1. track stack to iterate , collect reversed result stack
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> out = new Stack<>();     // use for record
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.push(node.val);                 // mock preOrder traversal     stack: L → R
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        // 2. return result
        while (!out.isEmpty())
            res.add(out.pop());
        return res;
    }
}
