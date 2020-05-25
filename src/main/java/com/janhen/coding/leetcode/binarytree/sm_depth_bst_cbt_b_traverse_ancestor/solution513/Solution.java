package com.janhen.coding.leetcode.binarytree.sm_depth_bst_cbt_b_traverse_ancestor.solution513;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode cur = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.right != null)
                queue.offer(cur.right);
            if (cur.left != null)
                queue.offer(cur.left);
        }
        return cur.val;
    }
}