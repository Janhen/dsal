package com.janhen.coding.leetcode.algs.dp.rob.solution337;

import com.janhen.coding.leetcode.structures.TreeNode;

//https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
class Solution {

    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        // rob 2 level house
        int val1 = root.val +
          // root.left.left and root.left.right NULL or node, LL,LR
          (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0) +
          // root.right.left and root.right.right NULL or node, RL, RR
          (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);

        // rob 1 level house
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}