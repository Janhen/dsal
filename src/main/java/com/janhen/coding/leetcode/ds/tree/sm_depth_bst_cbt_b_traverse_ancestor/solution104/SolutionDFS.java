package com.janhen.coding.leetcode.ds.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution104;

import com.janhen.coding.leetcode.structures.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

class SolutionDFS {
    // 等价于为每个及诶DNA添加 Depth 属性，之后遍历所有节点找到最大的深度
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int max = -1;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek().getKey();
            int depth = stack.pop().getValue();
            max = Math.max(max, depth);
            if (node.right != null)
                stack.push(new Pair<>(node.right, depth + 1));
            if (node.left != null)
                stack.push(new Pair<>(node.left, depth + 1));
        }
        return max;
    }
}


