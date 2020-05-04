package main.java.janhen.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution103;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);
        boolean isRight = true;
        while (!q.isEmpty()) {
            int cnt = q.size();
            List<Integer> level = new ArrayList<>();
            while (cnt -- > 0) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            if (isRight) {
                res.add(level);
            } else {
                Collections.reverse(level);
                res.add(level);
            }
            isRight = !isRight;
        }
        return res;
    }
}