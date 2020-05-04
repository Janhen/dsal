package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.solution257;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        dfs(root, "", paths);
        return paths;
    }

    void dfs (TreeNode root, String path, List<String> paths) {
        if  (root.left == null && root.right == null) {
            paths.add(path + root.val);    // NOTE: tail to handle differently
            return;
        }
        if (root.left != null)
            dfs(root.left, path + root.val + "->", paths);
        if (root.right != null)
            dfs(root.right, path + root.val + "->", paths);
    }
}
