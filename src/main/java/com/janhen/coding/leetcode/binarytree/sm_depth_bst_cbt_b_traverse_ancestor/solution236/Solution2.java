package com.janhen.coding.leetcode.binarytree.sm_depth_bst_cbt_b_traverse_ancestor.solution236;

// 236. Lowest Common Ancestor of a Binary Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import com.janhen.coding.leetcode.structures.TreeNode;

// 152 ms, faster than 7.41%
class Solution2 {
    /*
     * Same solution in several languages.
     * It's recursive and expands the meaning of the function.
     * If the current (sub)tree contains both p and q,
     * then the function result is their LCA.
     * If only one of them is in that subtree,
     * then the result is that one of them.
     * If neither are in that subtree, the result is null/None/nil.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}