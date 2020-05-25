package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution111;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionNR {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int cnt = q.size();
            depth ++;
            while (cnt -- > 0) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        throw new RuntimeException();
    }
}