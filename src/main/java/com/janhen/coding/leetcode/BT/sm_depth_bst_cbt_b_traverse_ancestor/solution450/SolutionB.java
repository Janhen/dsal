package com.janhen.coding.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution450;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionB {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        else {  // this to truncate
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;   // truncate to gc
                return rightNode;
            }
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
             TreeNode succ = minimum(root.right);
             succ.right = deleteMin(root.right);
             succ.left = root.left;
             root.left = root.right = null;  // truncate to gc
             return succ;
        }
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {  // this to truncate
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = deleteMin(node.left);     // re joint
        return node;
    }
}
