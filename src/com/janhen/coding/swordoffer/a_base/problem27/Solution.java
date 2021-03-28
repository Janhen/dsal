package com.janhen.coding.swordoffer.a_base.problem27;

import com.janhen.coding.swordoffer.structures.TreeNode;

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null)
            return ;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }
}
