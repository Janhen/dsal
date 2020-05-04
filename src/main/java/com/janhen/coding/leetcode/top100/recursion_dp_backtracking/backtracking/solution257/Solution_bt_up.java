package main.java.janhen.leetcode.top100.recursion_dp_backtracking.backtracking.solution257;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution_bt_up {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {     // recursion to bottom
            res.add("" + root.val);
            return res;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (int i = 0; i < leftPaths.size(); i ++)
            res.add(root.val + "->" + leftPaths.get(i));    // reverse add operation
        for (int i = 0; i < rightPaths.size(); i ++)
            res.add(root.val + "->" + rightPaths.get(i));
        return res;
    }
}
