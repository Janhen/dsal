package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution450;

import main.java.janhen.leetcode.structures.TreeNode;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {                   // truncate
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode succ = minimum(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
}
