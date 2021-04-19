package com.janhen.coding.leetcode.ds.tree.quality.solution450;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution2 {
    /*
     * find minimum and delete min to maintain bst order
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {  // this to truncate
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
            TreeNode successor = minimum(root.right);
            successor.right = deleteMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;  // truncate to gc
            return successor;
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
