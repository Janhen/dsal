package com.janhen.coding.leetcode.ds.tree.quality.solution94;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {

    public static final boolean GO = false;
    public static final boolean PRINT = true;

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command(GO, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.op == PRINT)
                res.add(command.node.val);
            else {
                if (command.node.right != null)
                    stack.push(new Command(GO, command.node.right));
                stack.push(new Command(PRINT, command.node));
                if (command.node.left != null)
                    stack.push(new Command(GO, command.node.left));
            }
        }
        return res;
    }

    class Command {
        boolean op;
        TreeNode node;

        Command(boolean b, TreeNode n) {
            op = b;
            node = n;
        }
    }
}
