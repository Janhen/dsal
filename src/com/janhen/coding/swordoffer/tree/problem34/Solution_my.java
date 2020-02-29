package com.janhen.swordoffer.tree.problem34;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.ArrayList;

public class Solution_my {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null)
            return paths;
        backtracking(root, target, new ArrayList<>(), paths);
        return paths;
    }

    private void backtracking(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                path.add(root.val);
                paths.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            backtracking(root.left, target - root.val, path, paths);
        }
        if (root.right != null) {
            backtracking(root.right, target - root.val, path, paths);
        }
        path.remove(path.size() - 1);
    }
}
