package com.janhen.coding.swordoffer.tree.problem68;

import com.janhen.coding.swordoffer.structures.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            lowestCommonAncestor(root.left, p, q);          // p,q all in left tree
        if (root.val < p.val && root.val < q.val)
            lowestCommonAncestor(root.right, p, q);           // p,q all in right tree
        return root;                                    // p,q is split into left and right
    }
}
