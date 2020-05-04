package main.java.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution226;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionDFS {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            TreeNode t = node.left;    // swap left, right
            node.left = node.right;
            node.right = t;
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }
        return root;
    }
}

