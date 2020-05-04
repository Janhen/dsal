package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution337;

import main.java.janhen.leetcode.structures.TreeNode;

//https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
class Solution {

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int val1 = root.val + (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0)
                + (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);  // cur + LL, LR, RL, RR
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}