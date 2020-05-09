package com.janhen.coding.leetcode.BT.sm_two_sub_sequence_convert_path.solution538;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionMorris {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        int sum = 0;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.right;
            if (cur2 != null) {
                while (cur2.left != null && cur2.left != cur1)
                    cur2 = cur2.left;
                if (cur2.left == null) {
                    cur2.left = cur1;
                    cur1 = cur1.right;
                    continue;
                } else {
                    cur2.left = null;
                }
            }
            cur1.val += sum;
            sum = cur1.val;
            cur1 = cur1.left;
        }
        return root;
    }
}