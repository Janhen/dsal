package main.java.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution129;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths.stream().mapToInt(p -> Integer.parseInt(p)).sum();
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        if (root.left != null)
            dfs(root.left, path + root.val, paths);
        if (root.right != null)
            dfs(root.right, path + root.val, paths);
    }
}