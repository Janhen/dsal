package com.janhen.swordoffer.tree.problem34;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.ArrayList;

public class Solution1 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        backtracking(root, target, new ArrayList<>(), res);
        return res;
    }

    // no need to handle root is null AND insure recursion root is valid
    private void backtracking(TreeNode root, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);     // Note: must reset, need control
            }
            return;
        }
        list.add(root.val);
        if (root.left != null) backtracking(root.left, target-root.val, list, res);
        if (root.right != null) backtracking(root.right, target-root.val, list, res);
        list.remove(list.size()-1);
    }
}
