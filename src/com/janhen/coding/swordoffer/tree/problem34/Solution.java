package com.janhen.coding.swordoffer.tree.problem34;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null)
            return paths;
        backtracking(root, target, paths, new ArrayList<>());
        return paths;
    }

    // handle in same way AND null is terminal
    private void backtracking(TreeNode root, int target, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
        if (root == null)
            return ;
        path.add(root.val);
        target -= root.val;      // like record state
        if (target == 0 && root.left == null && root.right == null) {    // is terminated
            paths.add(new ArrayList<>(path));
        } else {                                                      // can find int left OR right tree
            backtracking(root.left, target, paths, path);
            backtracking(root.right, target, paths, path);
        }
        path.remove(path.size() - 1);                      // need to backtracking
    }
}
