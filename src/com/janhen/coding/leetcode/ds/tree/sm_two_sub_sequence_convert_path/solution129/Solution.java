package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution129;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths.stream().mapToInt(p -> Integer.parseInt(p)).sum();
    }

    // path: string to record val
    // String immutable => every path transfer is new a object
    private void dfs(TreeNode root, String path, List<String> paths) {
        // 1. terminal condition
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        // 2. dfs to find element
        if (root.left != null)
            dfs(root.left, path + root.val, paths);
        if (root.right != null)
            dfs(root.right, path + root.val, paths);
    }
}