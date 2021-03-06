package com.janhen.coding.leetcode.ds.tree.quality.solution404;

// 404. Sum of Left Leaves
//https://leetcode.com/problems/sum-of-left-leaves/

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class SolutionDfs2 {

    // 栈只存放必要元素
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
                else
                    s.push(cur.left);        // non leaf
            }
            if (cur.right != null) {
                if (cur.right.left != null || cur.right.right != null)
                    s.push(cur.right);                   // skip right leaf
            }
        }
        return res;
    }
}