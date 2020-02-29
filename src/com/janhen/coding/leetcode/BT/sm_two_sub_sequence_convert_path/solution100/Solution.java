package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.leetcode.structures.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}