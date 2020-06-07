package com.janhen.coding.leetcode.dp.rob.solution337;

// 337. House Robber III
//https://leetcode.com/problems/house-robber-iii/

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionDp {

    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    // [0] 不包含当前节点
    // [1] 包含当前节点
    private int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}