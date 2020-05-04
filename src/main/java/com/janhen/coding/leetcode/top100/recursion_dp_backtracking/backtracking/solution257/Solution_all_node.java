package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.solution257;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution_all_node {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val + "->", paths);
        dfs(root.right, path + root.val + "->", paths);
    }
}
