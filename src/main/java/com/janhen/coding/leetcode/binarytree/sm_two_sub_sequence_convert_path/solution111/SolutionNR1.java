package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution111;

// 111. Minimum Depth of Binary Tree
//https://leetcode.com/problems/minimum-depth-of-binary-tree/

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SolutionNR1 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while (!q.isEmpty()) {
            int cnt = q.size();
            while (cnt -- > 0) {
                TreeNode node = q.peek().node;
                int level = q.poll().level;
                if (node.left == null && node.right == null)
                    return level;                        // first end
                if (node.left != null)
                    q.offer(new Pair(node.left, level + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, level + 1));
            }
        }
        throw new RuntimeException();
    }

    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}