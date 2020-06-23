package com.janhen.coding.leetcode.ds.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution236;

// 236. Lowest Common Ancestor of a Binary Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import com.janhen.coding.leetcode.structures.TreeNode;

// 6 ms, faster than 99.84%
class SolutionRef {

    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(found || root==null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null) {
            found = true;
            return root;
        }
        if(root.val==p.val||root.val==q.val)
            return root;
        else if(left!=null)
            return left;
        else if(right!=null)
            return right;
        return null;
    }
}