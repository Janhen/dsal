package com.janhen.coding.leetcode.tree.sm_two_sub_sequence_convert_path.solution113;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution1 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null
                && sum == root.val) {    // util leaf node, then subtract leaf node val
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        else {
            dfs(root.right, sum - root.val, path, res);
            dfs(root.left, sum - root.val, path, res);
        }
        path.remove(path.size() - 1);
    }
}