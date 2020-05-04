package main.java.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution113;

// 113. Path Sum II
// https://leetcode.com/problems/path-sum-ii/

/*

Medium

708

27
找出所有路径和为给定数的路径

路径的筛选

Favorite

Share
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution_new {
    // 减少递归次数
    // 每次都是一条新的路径，无需回退
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {    // util leaf node, then subtract leaf node val
            if (sum - root.val == 0) {
                path.add(root.val);
                res.add(path);
                return;
            }
        }
        path.add(root.val);
        if (root.left != null)
            dfs(root.left, sum - root.val, new ArrayList<>(path), res);
        if (root.right != null)
            dfs(root.right, sum - root.val, new ArrayList<>(path), res);
    }
}