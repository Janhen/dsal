package com.janhen.coding.leetcode.binarytree.sm_two_sub_sequence_convert_path.solution129;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return 0;
        dfs(root, "", paths);
        return paths.stream().mapToInt(Integer::valueOf).sum();
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val, paths);
        dfs(root.right, path + root.val, paths);
    }
}