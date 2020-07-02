package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution113;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution$$ {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    dfs(root, sum, new ArrayList<>(), res);
    return res;
  }

  private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
    // 1. terminal condition: util leaf node, then subtract leaf node val
    if (root.left == null && root.right == null) {
      if (sum - root.val == 0) {
        path.add(root.val);
        res.add(path);
        return;
      }
    }
    // 2. new list to record, then not need backtracking
    path.add(root.val);
    if (root.left != null)
      dfs(root.left, sum - root.val, new ArrayList<>(path), res);
    if (root.right != null)
      dfs(root.right, sum - root.val, new ArrayList<>(path), res);
  }
}