package com.janhen.coding.swordoffer.a_base.problem28;

import com.janhen.coding.swordoffer.structures.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    // compare two tree
    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
