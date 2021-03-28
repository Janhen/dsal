package com.janhen.coding.leetcode.algs.dp.rob.solution337;

// 337. House Robber III
//https://leetcode.com/problems/house-robber-iii/

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

class SolutionMemo {

    private Map<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return tryRob(root);
    }

    private int tryRob(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        if (memo.containsKey(root))
            return memo.get(root);
        int val1 = root.val + (root.left != null ? tryRob(root.left.left) + tryRob(root.left.right) : 0)
                + (root.right != null ? tryRob(root.right.left) + tryRob(root.right.right) : 0);
        int val2 = tryRob(root.left) + tryRob(root.right);
        int val =  Math.max(val1, val2);
        memo.put(root, val);
        return val;
    }
}