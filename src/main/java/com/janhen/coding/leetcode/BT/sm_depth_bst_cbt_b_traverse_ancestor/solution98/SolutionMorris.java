package com.janhen.coding.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution98;

// 98. Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/

/*

Medium

1575

240

Favorite

Share
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 */

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionMorris {
    //  1 ms, faster than 38.24%
    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && cur1.val <= pre.val) return false;
            pre = cur1;
            cur1 = cur1.right;
        }
        return true;
    }
}