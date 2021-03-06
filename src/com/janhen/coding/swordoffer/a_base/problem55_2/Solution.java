package com.janhen.coding.swordoffer.a_base.problem55_2;

import com.janhen.coding.swordoffer.structures.TreeNode;

public class Solution {
    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    // 求解高度的时候判断是否符合平衡性
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(right - left) > 1) {
            isBalanced = false;   // judge balanced
        }
        // get height
        return 1 + Math.max(left, right);
    }
}
