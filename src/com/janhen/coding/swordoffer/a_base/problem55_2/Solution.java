package com.janhen.swordoffer.a_base.problem55_2;

import com.janhen.swordoffer.structures.TreeNode;

public class Solution {
    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(right - left) > 1) isBalanced = false;   // judge balanced
        return 1 + Math.max(left, right);
    }
}
