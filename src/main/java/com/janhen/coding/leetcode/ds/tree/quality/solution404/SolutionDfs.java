package com.janhen.coding.leetcode.ds.tree.quality.solution404;

// 404. Sum of Left Leaves
//https://leetcode.com/problems/sum-of-left-leaves/

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class SolutionDfs {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        Deque<TreeNode> s = new LinkedList<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null)
                    res += cur.left.val;
                s.push(cur.left);
            }
            if (cur.right != null)
                s.push(cur.right);
        }
        return res;
    }
}