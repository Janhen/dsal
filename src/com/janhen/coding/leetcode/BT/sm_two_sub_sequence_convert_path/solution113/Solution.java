package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution113;

import com.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        backtracking(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {    // util leaf node, then subtract leaf node val
            if (sum - root.val == 0) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
        path.add(root.val);
        if (root.left != null)
            backtracking(root.left, sum - root.val, path, res);
        if (root.right != null)
            backtracking(root.right, sum - root.val, path, res);
        path.remove(path.size() - 1);
    }
}