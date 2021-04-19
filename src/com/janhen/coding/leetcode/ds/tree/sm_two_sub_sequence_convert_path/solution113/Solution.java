package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution113;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null)
            return paths;

        backtracking(root, sum, new ArrayList<>(), paths);
        return paths;
    }

    private void backtracking(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        // 1. terminal condition: util leaf node, then subtract leaf node val
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                path.add(root.val);
                // traverse full path
                paths.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }

        // 2. backtracking to iterate and back
        path.add(root.val);
        if (root.left != null)
            backtracking(root.left, sum - root.val, path, paths);
        if (root.right != null)
            backtracking(root.right, sum - root.val, path, paths);
        path.remove(path.size() - 1);
    }
}