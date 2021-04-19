package com.janhen.coding.leetcode.ds.tree.quality.solution230;

// 230. Kth Smallest Element in a BST
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionMorris {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode pre = null;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = cur1;
                }
            }
            if (--k == 0)
                return cur1.val;
            cur1 = cur1.right;
        }
        throw new IllegalArgumentException();
    }
}