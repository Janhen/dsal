package com.janhen.coding.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution145;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public static final boolean GO = false;
    public static final boolean PRINT = true;
    private class Command {
        boolean op;
        TreeNode node;
        Command(boolean s, TreeNode node) {
            this.op = s;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(GO, root));
        while (!stack.isEmpty()) {
            Command cmd = stack.pop();
            if (cmd.op == PRINT)
                res.add(cmd.node.val);
            else {
                stack.push(new Command(PRINT, cmd.node));
                if (cmd.node.right != null)
                    stack.push(new Command(GO, cmd.node.right));
                if (cmd.node.left != null)
                    stack.push(new Command(GO, cmd.node.left));
                // reverse : L --> R --> D
            }
        }
        return res;
    }
}