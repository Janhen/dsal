package com.janhen.coding.leetcode.binarytree.sm_depth_bst_cbt_b_traverse_ancestor.solution98;

import com.janhen.coding.leetcode.structures.TreeNode;


/*
 *    			10
 *    		   /  \
 *    		  7   20
 *    		      / \
 *    		     5  40
 * node.left.val < node.val
 *  - right subtree of left child, value < node.val
 * node.right.val > node.val
 *  - left subtree of the right child, value > node.val
 * wikipedia上有伪码：
 *
 * truct TreeNode {
 *     int key;
 *     int value;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 *
 * bool isBST(struct TreeNode *node, int minKey, int maxKey) {
 *     if(node == NULL) return true;
 *     if(node->key < minKey || node->key > maxKey) return false;
 *
 *     return isBST(node->left, minKey, node->key) && isBST(node->right, node->key, maxKey);
 * }
 *
 *
 * if(isBST(root, INT_MIN, INT_MAX)) {
 *     puts("This is a BST.");
 * } else {
 *     puts("This is NOT a BST!");
 * }
 * 实际上就是每次往下看，node都确保被夹在一个范围
 *
 * 0 ms, faster than 100.00%
 */
// todo Q
class SolutionR {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);     // init value is max AND min
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);      // like search
    }
}