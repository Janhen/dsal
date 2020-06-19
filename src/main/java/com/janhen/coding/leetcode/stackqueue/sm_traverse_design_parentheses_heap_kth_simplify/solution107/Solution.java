package com.janhen.coding.leetcode.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution107;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int cnt = q.size();
            List<Integer> level = new ArrayList<>();
            while (cnt -- > 0) {
                TreeNode front = q.poll();
                level.add(front.val);
                if (front.left != null)
                    q.offer(front.left);
                if (front.right != null)
                    q.offer(front.right);
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}