package com.janhen.coding.leetcode.BT.sm_two_sub_sequence_convert_path.solution437;

import com.janhen.coding.leetcode.structures.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int res = 0;
        res += getPathCountFromNode(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int getPathCountFromNode(TreeNode node, int target) {
        if (node == null)
            return 0;
        int res = 0;
        if (node.val == target)  // NOTE: can negative to ...
            res += 1;
        res += getPathCountFromNode(node.left, target - node.val);
        res += getPathCountFromNode(node.right, target - node.val);
        return res;
    }
}