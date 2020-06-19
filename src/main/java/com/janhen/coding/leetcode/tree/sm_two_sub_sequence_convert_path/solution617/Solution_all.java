package com.janhen.coding.leetcode.tree.sm_two_sub_sequence_convert_path.solution617;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution_all {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        int val = (t1 != null? t1.val : 0) + (t2 != null ? t2.val : 0);     // every node to traverse
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
}